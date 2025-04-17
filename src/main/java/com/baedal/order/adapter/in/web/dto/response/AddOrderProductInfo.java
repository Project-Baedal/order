package com.baedal.order.adapter.in.web.dto.response;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class AddOrderProductInfo {

  @Schema(description = "메뉴명")
  private String productName;

  @Schema(description = "금액")
  private int productPrice;

}
