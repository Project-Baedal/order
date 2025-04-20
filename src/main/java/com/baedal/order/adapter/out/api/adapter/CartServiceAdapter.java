package com.baedal.order.adapter.out.api.adapter;

import com.baedal.order.adapter.out.api.client.CartServiceClient;
import com.baedal.order.adapter.out.api.mapper.CartApiMapper;
import com.baedal.order.application.port.out.CartClientPort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class CartServiceAdapter implements CartClientPort {

  private final CartServiceClient client;
  private final CartApiMapper mapper;

}
