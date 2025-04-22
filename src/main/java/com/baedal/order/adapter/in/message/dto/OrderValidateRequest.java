package com.baedal.order.adapter.in.message.dto;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class OrderValidateRequest {

  private String orderTransactionId;
  private String domain;

}
