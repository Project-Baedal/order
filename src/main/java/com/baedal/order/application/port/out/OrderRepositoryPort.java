package com.baedal.order.application.port.out;

import com.baedal.order.domain.model.AddOrder;
import com.baedal.order.domain.model.Order;
import com.baedal.order.domain.model.OrderStatus;

public interface OrderRepositoryPort {
  Order save(AddOrder addOrder);

  Order findById(Long id);

  void changeOrderStatus(Long orderId, OrderStatus status);
}
