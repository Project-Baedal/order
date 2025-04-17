package com.baedal.order.adapter.out.api.adapter;

import com.baedal.order.adapter.out.api.client.StoreServiceClient;
import com.baedal.order.adapter.out.api.dto.GetStoreResponse;
import com.baedal.order.adapter.out.api.mapper.StoreApiMapper;
import com.baedal.order.application.port.out.StoreClientPort;
import com.baedal.order.domain.store.Store;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class StoreServiceAdapter implements StoreClientPort {

  private final StoreServiceClient client;
  private final StoreApiMapper mapper;

  @Override
  public Store findByStoreId(Long storeId) {
    GetStoreResponse response = client.findByStoreId(storeId);
    return mapper.responseToDomain(response);
  }
}
