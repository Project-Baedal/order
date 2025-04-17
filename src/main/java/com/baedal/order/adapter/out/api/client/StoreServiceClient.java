package com.baedal.order.adapter.out.api.client;

import com.baedal.order.adapter.out.api.dto.GetStoreResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient(name = "order", url = "${servers.order.url}")
public interface StoreServiceClient {

  @GetMapping("/getStore")
  GetStoreResponse findByStoreId(Long storeId);

}
