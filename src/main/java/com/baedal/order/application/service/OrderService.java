package com.baedal.order.application.service;

import com.baedal.order.application.command.AddOrderCommand;
import com.baedal.order.application.command.CancelExpiredOrderCommand;
import com.baedal.order.application.command.OrderSuccessCommand;
import com.baedal.order.application.command.OrderValidateCommand.Request;
import com.baedal.order.application.command.store.RequestStoreOrderCommand;
import com.baedal.order.application.mapper.OrderApplicationMapper;
import com.baedal.order.application.port.in.OrderUseCase;
import com.baedal.order.application.port.out.MessageSenderPort;
import com.baedal.order.application.port.out.OrderRepositoryPort;
import com.baedal.order.application.port.out.OrderTempCacheRepositoryPort;
import com.baedal.order.application.port.out.OrderValidateCacheRepositoryPort;
import com.baedal.order.application.port.out.PaymentClientPort;
import com.baedal.order.domain.business.FutureManager;
import com.baedal.order.domain.business.OrderCalculator;
import com.baedal.order.domain.business.OrderExtractor;
import com.baedal.order.domain.business.OrderValidator;
import com.baedal.order.domain.model.AddOrder;
import com.baedal.order.domain.model.AddOrderValidate;
import com.baedal.order.domain.model.FailOrder;
import com.baedal.order.domain.model.TempOrder;
import com.baedal.order.domain.model.Order;
import com.baedal.order.domain.model.OrderStatus;
import com.baedal.order.domain.model.ValidateResult;
import com.baedal.order.domain.model.cart.ValidateCartOrderInfo;
import com.baedal.order.domain.model.payment.GetPaymentUrl;
import com.baedal.order.domain.model.payment.GetPaymentUrl.Response;
import com.baedal.order.domain.model.product.ValidateProductOrderInfo;
import com.baedal.order.domain.model.rider.AddRiderQueueRequest;
import com.baedal.order.domain.model.store.ValidateStoreOrderInfo;
import com.baedal.order.util.ThreadUtil;
import java.util.Set;
import java.util.UUID;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class OrderService implements OrderUseCase {

  private final ExecutorService executorService = Executors.newVirtualThreadPerTaskExecutor();
  private final FutureManager futureManager = new FutureManager();
  private final OrderCalculator orderCalculator = new OrderCalculator();
  private final OrderExtractor orderExtractor = new OrderExtractor();

  private final OrderApplicationMapper mapper;
  private final OrderValidateCacheRepositoryPort orderValidateCacheRepositoryPort;
  private final OrderTempCacheRepositoryPort orderTempCacheRepositoryPort;
  private final MessageSenderPort messageSenderPort;
  private final PaymentClientPort paymentClientPort;
  private final OrderValidator orderValidator;
  private final OrderRepositoryPort orderRepositoryPort;

  /**
   * 응답 값을 받아오는 요청에만 버츄얼 스레드 적용
   */
  @Override
  @Transactional
  public AddOrderCommand.Response addOrder(AddOrderCommand.Request req) {

    // note. 수정 예정
    // 회원ID
    Long customerId = 1L;

    // 상태 추적을 위한 고유값(UUID) 생성
    String orderTransactionId = UUID.randomUUID().toString();

    // 주문 정보 임시 저장
    orderTempCacheRepositoryPort.saveTempOrder(orderTransactionId, req);

    // 결제 요청 전송 및 결제 URL 반환
    Future<Response> paymentFuture = executorService.submit(() -> {
      GetPaymentUrl.Request paymentRequest = mapper.getPaymentUrlToDomain(
          req, orderTransactionId, customerId.toString()
      );
      return paymentClientPort.getPaymentUrl(paymentRequest);
    });

    // 전달 받은 장바구니 값과 저장된 장바구니의 값이 동일한지 확인
    ValidateCartOrderInfo.Request cartReq = mapper.validateCartOrderInfoToDomain(
        orderTransactionId,
        customerId,
        req.getProductInfo(),
        req.getStoreId()
    );
    messageSenderPort.validateCartOrderInfo(cartReq);

    // 상품이 판매 중인지 상태 확인
    ValidateProductOrderInfo.Request productReq = mapper.validateProductOrderInfoToDomain(
        req.getProductInfo(), orderTransactionId, req.getStoreId()
    );
    messageSenderPort.validateProductOrderInfo(productReq);

    // 매장이 영업 중인지 상태 확인
    ValidateStoreOrderInfo.Request storeReq = mapper.validateStoreOrderInfoToDomain(req,
        orderTransactionId);
    messageSenderPort.validateStoreOrderInfo(storeReq);

    GetPaymentUrl.Response paymentResponse = futureManager.extract(paymentFuture);
    return mapper.getPaymentUrlToResponse(paymentResponse, orderTransactionId);
  }

  @Override
  public void orderValidate(Request req) {

    String orderTransactionId = req.getOrderTransactionId();

    // 검증 결과 조회
    Set<ValidateResult> result = orderValidateCacheRepositoryPort.getOrderValidationStatus(
        orderTransactionId
    );

    // 전달 받은 요청을 검증 결과에 포함
    ValidateResult tempResult = mapper.orderValidateResultToDomain(req);
    result.add(tempResult);

    // 크기가 기준에 미치지 못할 경우 검증 결과를 저장하고 종료
    if (!orderValidator.validateCount(result)) {
      AddOrderValidate addOrderValidateReq = mapper.addOrderValidateToDomain(req);
      orderValidateCacheRepositoryPort.addOrderValidate(addOrderValidateReq);
      return;
    }

    orderValidator.getErrorMessage(result).ifPresentOrElse(message -> {
      // 실패한 검증이 있으면 주문 실패 메세지 전달하고 종료
      messageSenderPort.failOrder(orderTransactionId, message);

    }, () -> {
      // 검증 성공시 결제 승인 메세지 전달
      messageSenderPort.approvePayment(orderTransactionId);
      orderValidateCacheRepositoryPort.deleteKey(orderTransactionId);
    });
  }

  @Transactional
  public void confirmOrder(Long orderId) {
    AddRiderQueueRequest req = mapper.addRiderQueueRequest(orderId);
    messageSenderPort.orderAccepted_addRiderQueue(orderId, req);

    orderRepositoryPort.changeOrderStatus(orderId, OrderStatus.ACCEPTED);
  }

  @Transactional
  public void cancelOrder(Long orderId) {
    // TODO: 주문 환불
    orderRepositoryPort.changeOrderStatus(orderId, OrderStatus.DENIED);
  }

  @Override
  @Transactional
  public void orderCancel(Long orderId) {
    // 주문이 존재하는지 조회
    Order order = orderRepositoryPort.findById(orderId);

    // 주문 상태 검증
    orderValidator.validateSucceededStatus(order);

    // 주문의 상태를 변경
    orderRepositoryPort.cancelOrderById(order);

    // 환불 요청
    messageSenderPort.cancelPayment(order.getPaymentId());

  }

  @Override
  public void orderSuccess(OrderSuccessCommand.Request req) {

    // 임시 주문 조회
    TempOrder tempOrder = orderTempCacheRepositoryPort.findByTransactionId(
        req.getOrderTransactionId()
    );

    // 주문 저장
    AddOrder order = mapper.tempOrderToDomain(tempOrder);
    orderRepositoryPort.save(order);

    // 매장 주문 요청 메세지 큐 전달
    RequestStoreOrderCommand.Request storeRequest = mapper.addOrderToDomain(order);
    messageSenderPort.requestStoreOrder(storeRequest);
  }

  @Override
  @Transactional
  public void cancelExpiredOrder(CancelExpiredOrderCommand.Request req) {

    String transactionId = req.getOrderTransactionId();

    // 처리 시간까지 남은 시간만큼 대기
    long sleepMillis = orderCalculator.millisSinceNow(req.getExpiredAt());
    if (sleepMillis > 0) ThreadUtil.sleep(sleepMillis);

    // 검증 현황 조회
    Set<ValidateResult> validates = orderValidateCacheRepositoryPort.getOrderValidationStatus(
        transactionId
    );

    if (!orderValidator.isPaymentValidated(validates)) {
      // 결제가 진행되지 않았으면 검증 결과 삭제
      orderValidateCacheRepositoryPort.deleteKey(transactionId);
      return;
    }

    // 결제가 진행된 경우, 실패 도메인 추출
    String failDomain = orderExtractor.validateFailDomain(validates);

    // 임시 주문 정보 조회
    TempOrder tempOrder = orderTempCacheRepositoryPort.findByTransactionId(transactionId);

    // 주문 저장
    AddOrder addOrder = mapper.addFailOrderToDomain(tempOrder, OrderStatus.CANCELED);
    orderRepositoryPort.save(addOrder);
  }
}
