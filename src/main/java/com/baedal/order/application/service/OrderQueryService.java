package com.baedal.order.application.service;

import com.baedal.order.application.port.out.OrderRepositoryPort;
import com.baedal.order.domain.model.Order;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class OrderQueryService {

  private final OrderRepositoryPort port;

  @Transactional(readOnly = true)
  public Order findOrderByOrderId(Long orderId) {
    return port.findById(orderId);
  }
}
