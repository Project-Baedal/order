package com.baedal.order.adapter.out.restApi.adapter;

import com.baedal.order.adapter.out.restApi.client.StoreServiceClient;
import com.baedal.order.adapter.out.restApi.mapper.StoreApiMapper;
import com.baedal.order.application.port.out.StoreClientPort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class StoreServiceAdapter implements StoreClientPort {

  private final StoreServiceClient client;
  private final StoreApiMapper mapper;

}
