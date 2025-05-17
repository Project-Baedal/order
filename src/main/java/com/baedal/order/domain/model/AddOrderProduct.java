package com.baedal.order.domain.model;

import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
public class AddOrderProduct {

  private Long productId;
  private String name;
  private int price;

}
