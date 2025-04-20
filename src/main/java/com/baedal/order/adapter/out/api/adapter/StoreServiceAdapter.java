package com.baedal.order.adapter.out.api.adapter;

import com.baedal.order.adapter.out.api.client.StoreServiceClient;
import com.baedal.order.adapter.out.api.mapper.StoreApiMapper;
import com.baedal.order.application.port.out.StoreClientPort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class StoreServiceAdapter implements StoreClientPort {

  private final StoreServiceClient client;
  private final StoreApiMapper mapper;

}
