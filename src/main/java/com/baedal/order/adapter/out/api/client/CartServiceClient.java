package com.baedal.order.adapter.out.api.client;

import com.baedal.order.adapter.out.api.dto.GetCartResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient(name = "cart", url = "${servers.cart.url}")
public interface CartServiceClient {

  @GetMapping("/")
  GetCartResponse findByCustomerId(Long customerId);

}
