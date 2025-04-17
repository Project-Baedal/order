package com.baedal.order.adapter.out.api.adapter;

import com.baedal.order.adapter.out.api.client.ProductServiceClient;
import com.baedal.order.adapter.out.api.dto.GetProductResponse;
import com.baedal.order.adapter.out.api.mapper.ProductApiMapper;
import com.baedal.order.application.port.out.ProductClientPort;
import com.baedal.order.domain.product.Product;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class ProductServiceAdapter implements ProductClientPort {

  private final ProductServiceClient client;
  private final ProductApiMapper mapper;

  @Override
  public List<Product> findByProductIds(List<Long> productIds) {
    List<GetProductResponse> response = client.findByProductIds(productIds);
    return mapper.responseToDomain(response);
  }
}
