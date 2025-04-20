package com.baedal.order.adapter.out.api.client;

import org.springframework.cloud.openfeign.FeignClient;

@FeignClient(name = "product", url = "${servers.product.url}")
public interface ProductServiceClient {

}
