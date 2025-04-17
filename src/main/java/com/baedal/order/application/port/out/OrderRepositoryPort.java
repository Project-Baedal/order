package com.baedal.order.application.port.out;

import com.baedal.order.domain.model.AddOrder;
import com.baedal.order.domain.model.Order;

public interface OrderRepositoryPort {

  Order save(AddOrder addOrder);
}
