package com.baedal.order.adapter.out.api.client;

import com.baedal.order.adapter.out.api.dto.GetStoreResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "store", url = "${servers.store.url}")
public interface StoreServiceClient {

  @GetMapping("/deliveryInfo/{storeId}")
  GetStoreResponse findByStoreId(@PathVariable Long storeId);

}
