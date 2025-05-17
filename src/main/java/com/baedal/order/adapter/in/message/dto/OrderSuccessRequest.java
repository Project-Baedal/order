package com.baedal.order.adapter.in.message.dto;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class OrderSuccessRequest {

  private Long paymentId;
  private String orderTransactionId;

}
