package com.baedal.order.adapter.out.restApi.client;

import org.springframework.cloud.openfeign.FeignClient;

@FeignClient(name = "cart", url = "${servers.cart.url}")
public interface CartServiceClient {

}
