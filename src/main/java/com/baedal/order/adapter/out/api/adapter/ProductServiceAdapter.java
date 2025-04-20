package com.baedal.order.adapter.out.api.adapter;

import com.baedal.order.adapter.out.api.client.ProductServiceClient;
import com.baedal.order.adapter.out.api.mapper.ProductApiMapper;
import com.baedal.order.application.port.out.ProductClientPort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class ProductServiceAdapter implements ProductClientPort {

  private final ProductServiceClient client;
  private final ProductApiMapper mapper;

}
