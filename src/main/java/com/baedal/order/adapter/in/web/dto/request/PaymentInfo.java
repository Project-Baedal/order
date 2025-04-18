package com.baedal.order.adapter.in.web.dto.request;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class PaymentInfo {
  private String paymentMethod;
}
