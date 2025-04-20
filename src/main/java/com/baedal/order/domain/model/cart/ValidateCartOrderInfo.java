package com.baedal.order.domain.model.cart;

import java.util.List;
import lombok.Builder;
import lombok.Getter;

public class ValidateCartOrderInfo {

  @Getter
  @Builder
  public static class Request {
    private String orderTransactionId;
    private Long customerId;
    private Long storeId;
    private List<Long> productIds;
  }

}
