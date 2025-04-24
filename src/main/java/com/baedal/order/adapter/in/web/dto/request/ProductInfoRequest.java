package com.baedal.order.adapter.in.web.dto.request;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class ProductInfoRequest {

  private Long productId;
  private String productName;
  private int price;

}
