package com.baedal.order.application.service;

import com.baedal.order.application.command.AddOrderCommand;
import com.baedal.order.application.mapper.OrderApplicationMapper;
import com.baedal.order.application.port.in.OrderUseCase;
import com.baedal.order.application.port.out.MessageSenderPort;
import com.baedal.order.application.port.out.OrderCacheRepositoryPort;
import com.baedal.order.application.port.out.PaymentClientPort;
import com.baedal.order.domain.model.cart.ValidateCartOrderInfo;
import com.baedal.order.domain.model.product.ValidateProductOrderInfo;
import com.baedal.order.domain.model.store.ValidateStoreOrderInfo;
import com.baedal.order.domain.payment.GetPaymentUrl;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class OrderService implements OrderUseCase {

  private final OrderApplicationMapper mapper;
  private final OrderCacheRepositoryPort orderCacheRepository;
  private final MessageSenderPort messageSenderPort;
  private final PaymentClientPort paymentClientPort;

  @Override
  @Transactional
  public AddOrderCommand.Response addOrder(AddOrderCommand.Request req) {

    // note. 수정 예정
    // 회원ID
    String userId = "1";

    // 상태 추적을 위한 고유값(UUID) 생성 및 캐시 저장
    String orderTransactionId = orderCacheRepository.generateAndSaveOrderTransactionId();

    // 전달 받은 장바구니 값과 저장된 장바구니의 값이 동일한지 확인
    ValidateCartOrderInfo.Request cartReq = mapper.validateCartOrderInfoToDomain(req, orderTransactionId);
    messageSenderPort.validateCartOrderInfo(cartReq);

    // 상품이 판매 중인지 상태 확인
    ValidateProductOrderInfo.Request productReq = mapper.validateProductOrderInfoToDomain(req, orderTransactionId);
    messageSenderPort.validateProductOrderInfo(productReq);

    // 매장이 영업 중인지 상태 확인
    ValidateStoreOrderInfo.Request storeReq = mapper.validateStoreOrderInfoToDomain(req, orderTransactionId);
    messageSenderPort.validateStoreOrderInfo(storeReq);

    // 결제 요청 전송 및 결제 URL 반환
    GetPaymentUrl.Request paymentRequest = mapper.getPaymentUrlToDomain(
        req, orderTransactionId, userId
    );
    GetPaymentUrl.Response paymentResponse = paymentClientPort.getPaymentUrl(paymentRequest);
    return mapper.getPaymentUrlToResponse(paymentResponse);
  }
}
