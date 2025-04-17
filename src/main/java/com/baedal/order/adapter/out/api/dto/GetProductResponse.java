package com.baedal.order.adapter.out.api.dto;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class GetProductResponse {

  private String productName;
  private int productPrice;

}
