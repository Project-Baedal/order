package com.baedal.order.adapter.in.web.dto.request;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import java.util.List;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class AddOrderRequest {

  @Schema(description = "매장 ID")
  @NotNull
  private Long storeId;

  @Schema(description = "상품 ID")
  @NotNull
  private List<Long> productIds;

  @Schema(description = "배달 주소")
  @NotBlank
  private String deliveryAddress;

  @Schema(description = "연락처")
  @NotBlank
  private String phoneNumber;

  @Schema(description = "결제 수단")
  @NotBlank
  private String paymentMethod;

  @Schema(description = "총 결제 금액")
  @Positive
  private int totalAmount;

}
