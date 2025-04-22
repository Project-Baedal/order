package com.baedal.order.application.command.product;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class GetProductCommand {

  private String productName;
  private int productPrice;

}
