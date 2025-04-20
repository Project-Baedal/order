package com.baedal.order.adapter.in.web.dto.request;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.Positive;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class PaymentInfo {

  @Schema(description = "결제 수단")
  private String paymentMethod;

  @Schema(description = "총 결제 금액")
  @Positive
  private int totalAmount;

}
