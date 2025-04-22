package com.baedal.order.domain.model;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class AddOrderValidate {

  private String orderTransactionId;
  private String domain;
  private boolean status;
  private String message;

}
