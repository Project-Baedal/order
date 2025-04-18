package com.baedal.order.domain.store;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class Store {

  private String storeName;
  private int deliveryAmount;

}
