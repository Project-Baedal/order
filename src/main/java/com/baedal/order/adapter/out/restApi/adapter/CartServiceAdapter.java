package com.baedal.order.adapter.out.restApi.adapter;

import com.baedal.order.adapter.out.restApi.client.CartServiceClient;
import com.baedal.order.adapter.out.restApi.mapper.CartApiMapper;
import com.baedal.order.application.port.out.CartClientPort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class CartServiceAdapter implements CartClientPort {

  private final CartServiceClient client;
  private final CartApiMapper mapper;

}
