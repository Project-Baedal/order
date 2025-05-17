package com.baedal.order.application.command.store;

import java.time.LocalDateTime;
import java.util.List;
import lombok.Builder;
import lombok.Getter;

public class RequestStoreOrderCommand {

  @Getter
  @Builder
  public static class Request {
    private Long storeId;
    private Long paymentId;
    private String deliveryAddress;
    private String phoneNumber;
    private LocalDateTime orderDate;
    private List<Long> productIds;
  }



}
