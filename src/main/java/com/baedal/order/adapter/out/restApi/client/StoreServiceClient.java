package com.baedal.order.adapter.out.restApi.client;

import org.springframework.cloud.openfeign.FeignClient;

@FeignClient(name = "store", url = "${servers.store.url}")
public interface StoreServiceClient {

}
