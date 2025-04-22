package com.baedal.order.application.command;

import lombok.Builder;
import lombok.Getter;

public class OrderValidateCommand {

  @Getter
  @Builder
  public static class Request{
    private String orderTransactionId;
    private String domain;
  }

}
