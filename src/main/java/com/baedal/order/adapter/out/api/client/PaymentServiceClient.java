package com.baedal.order.adapter.out.api.client;

import com.baedal.order.adapter.out.api.dto.GetPaymentUrlRequest;
import com.baedal.order.adapter.out.api.dto.GetPaymentUrlResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient(name = "payment", url = "${servers.payment.url}")
public interface PaymentServiceClient {

  @GetMapping("/")
  GetPaymentUrlResponse getPaymentUrl(GetPaymentUrlRequest req);

}
