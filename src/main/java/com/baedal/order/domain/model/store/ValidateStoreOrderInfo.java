package com.baedal.order.domain.model.store;

import lombok.Builder;
import lombok.Getter;

public class ValidateStoreOrderInfo {

  @Getter
  @Builder
  public static class Request {
    private String orderTransactionId;
    private Long storeId;
    private int deliveryAmount;
  }

}
