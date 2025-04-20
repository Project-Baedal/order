package com.baedal.order.adapter.out.api.client;

import org.springframework.cloud.openfeign.FeignClient;

@FeignClient(name = "store", url = "${servers.store.url}")
public interface StoreServiceClient {

}
