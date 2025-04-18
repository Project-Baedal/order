package com.baedal.order.application.service;

import com.baedal.order.application.command.AddOrderCommand;
import com.baedal.order.application.mapper.OrderApplicationMapper;
import com.baedal.order.application.port.in.OrderUseCase;
import com.baedal.order.application.port.out.CartClientPort;
import com.baedal.order.application.port.out.MessageSenderPort;
import com.baedal.order.application.port.out.OrderRepositoryPort;
import com.baedal.order.application.port.out.ProductClientPort;
import com.baedal.order.application.port.out.StoreClientPort;
import com.baedal.order.domain.model.AddOrder;
import com.baedal.order.domain.model.Order;
import com.baedal.order.domain.product.Product;
import java.util.ArrayList;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class OrderService implements OrderUseCase {

  private final OrderApplicationMapper mapper;
  private final OrderRepositoryPort orderRepository;
  private final CartClientPort cartClientPort;
  private final ProductClientPort productClientPort;
  private final StoreClientPort storeClientPort;
  private final MessageSenderPort messageSenderPort;

  @Override
  @Transactional
  public AddOrderCommand.Response addOrder(AddOrderCommand.Request req) {

    // 1. 장바구니 도메인에서 CustomerId 를 활용해 장바구니 목록을 가져오고, Request 값과 동일한지 검증 한다
    // cartClientPort.findByCustomerId(req.getCustomerId());

    // 2. 주문 도메인에서 상품명/가격을 조회한다.
    // productClientPort.findByProductIds(req.getProductIds());
    List<Product> products = new ArrayList<>();

    // 3. 매장 도메인에서 상품을 갖고 있는 매장의 상태 값을 검증한다.
    // storeClientPort.findByStoreId(req.getStoreId());

    // 위의 검증이 모두 통과하였을 경우, 주문 데이터를 생성한다. 이때 Status 값은 Pending ( 결제 대기 ) 상태
    AddOrder addOrder = mapper.toAddOrder(req, products);
    Order order = orderRepository.save(addOrder);

    // 주문 ID 값과 함께 결제 도메인으로 메세지 큐를 전달한다.
    messageSenderPort.sendPaymentRequest(order.getOrderId(), req.getPaymentInfo());

    return mapper.toResponse(order);
  }
}
