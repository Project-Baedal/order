package com.baedal.order.adapter.out.restApi.adapters;

import com.baedal.order.adapter.out.restApi.client.ProductServiceClient;
import com.baedal.order.adapter.out.restApi.mapper.ProductApiMapper;
import com.baedal.order.application.port.out.ProductClientPort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class ProductServiceAdapter implements ProductClientPort {

  private final ProductServiceClient client;
  private final ProductApiMapper mapper;

}
