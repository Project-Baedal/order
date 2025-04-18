package com.baedal.order.domain.cart;

import java.util.List;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class Cart {

  private Long storeId;
  private List<Long> productIds;
}
