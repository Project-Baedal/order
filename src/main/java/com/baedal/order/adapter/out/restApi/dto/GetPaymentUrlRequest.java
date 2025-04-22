package com.baedal.order.adapter.out.restApi.dto;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class GetPaymentUrlRequest {
  private String partnerOrderId;
  private String partnerUserId;
  private String itemName;
  private Integer quantity;
  private Integer totalAmount;
  private Integer taxFreeAmount;
}
