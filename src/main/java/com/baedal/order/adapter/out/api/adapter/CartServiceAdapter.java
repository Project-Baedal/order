package com.baedal.order.adapter.out.api.adapter;

import com.baedal.order.adapter.out.api.client.CartServiceClient;
import com.baedal.order.adapter.out.api.dto.GetCartResponse;
import com.baedal.order.adapter.out.api.mapper.CartApiMapper;
import com.baedal.order.application.port.out.CartClientPort;
import com.baedal.order.domain.cart.Cart;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class CartServiceAdapter implements CartClientPort {

  private final CartServiceClient client;
  private final CartApiMapper mapper;

  @Override
  public Cart findByCustomerId(Long customerId) {
    GetCartResponse response = client.findByCustomerId(customerId);
    return mapper.responseToDomain(response);
  }
}
