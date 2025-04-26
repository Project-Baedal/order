package com.baedal.order.domain.model;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class SuccessOrderValidate {

  private String orderTransactionId;
  private String domain;

}
