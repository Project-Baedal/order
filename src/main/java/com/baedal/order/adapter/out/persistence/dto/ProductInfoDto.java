package com.baedal.order.adapter.out.persistence.dto;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class ProductInfoDto {
  private Long productId;
  private String productName;
  private int price;
}
