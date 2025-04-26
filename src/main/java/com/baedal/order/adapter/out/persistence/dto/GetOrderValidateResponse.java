package com.baedal.order.adapter.out.persistence.dto;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class GetOrderValidateResponse {

  private String domain;
  private boolean status;
  private String message;

}
