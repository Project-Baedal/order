package com.baedal.order.adapter.out.restApi.client;

import com.baedal.order.adapter.out.restApi.dto.GetPaymentUrlRequest;
import com.baedal.order.adapter.out.restApi.dto.GetPaymentUrlResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient(name = "payment", url = "${servers.payment.url}")
public interface PaymentServiceClient {

  @GetMapping("/pay")
  GetPaymentUrlResponse getPaymentUrl(GetPaymentUrlRequest req);

}
