package com.baedal.order.adapter.out.persistence.dto;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class AddOrderValidateRequest {

  private String domain;
  private boolean status;
  private String message;

}
