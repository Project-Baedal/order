package com.baedal.order.adapter.out.api.dto;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class GetStoreResponse {

  private String storeName;
  private int deliveryAmount;

}
