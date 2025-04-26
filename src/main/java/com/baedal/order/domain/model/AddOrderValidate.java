package com.baedal.order.domain.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class AddOrderValidate {

  private String orderTransactionId;
  private String domain;
  private boolean status;
  private String message;

}
