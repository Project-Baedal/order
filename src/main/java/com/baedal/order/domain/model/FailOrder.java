package com.baedal.order.domain.model;

import lombok.Builder;
import lombok.Getter;

public class FailOrder {

  @Builder
  @Getter
  public static class Request {
    private String orderTransactionId;
    private String domain;
  }

}
