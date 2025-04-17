package com.baedal.order.domain.product;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class Product {

  private String name;
  private int price;

}
