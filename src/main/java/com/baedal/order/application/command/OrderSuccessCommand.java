package com.baedal.order.application.command;

import lombok.Builder;
import lombok.Getter;

public class OrderSuccessCommand {

  @Getter
  @Builder
  public static class Request {
    private Long paymentId;
    private String orderTransactionId;
  }

}
