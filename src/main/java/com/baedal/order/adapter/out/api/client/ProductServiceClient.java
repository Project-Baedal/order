package com.baedal.order.adapter.out.api.client;

import com.baedal.order.adapter.out.api.dto.GetProductResponse;
import java.util.List;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient(name = "product", url = "${servers.product.url}")
public interface ProductServiceClient {

  @GetMapping("/products")
  List<GetProductResponse> findByProductIds(List<Long> productIds);

}
