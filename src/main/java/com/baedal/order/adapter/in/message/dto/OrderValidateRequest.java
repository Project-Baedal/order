package com.baedal.order.adapter.in.message.dto;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class OrderValidateRequest {

  private String domain;
  private boolean status;
  private String message;

}
