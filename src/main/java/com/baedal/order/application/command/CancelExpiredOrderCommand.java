package com.baedal.order.application.command;

import java.time.LocalDateTime;
import lombok.Builder;
import lombok.Getter;

public class CancelExpiredOrderCommand {

  @Getter
  @Builder
  public static class Request {

    private String orderTransactionId;
    private LocalDateTime expiredAt;

  }

  
}
