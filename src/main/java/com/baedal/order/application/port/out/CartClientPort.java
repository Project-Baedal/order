package com.baedal.order.application.port.out;

import com.baedal.order.domain.cart.Cart;

public interface CartClientPort {

  Cart findByCustomerId(Long customerId);
}
