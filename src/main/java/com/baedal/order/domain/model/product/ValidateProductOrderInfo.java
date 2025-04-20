package com.baedal.order.domain.model.product;

import java.util.List;
import lombok.Builder;
import lombok.Getter;

public class ValidateProductOrderInfo {

  @Getter
  @Builder
  public static class Request {
    private String orderTransactionId;
    private Long storeId;
    private List<Long> productIds;
    private int totalAmount;
  }

}
