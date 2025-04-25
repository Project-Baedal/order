package com.baedal.order.adapter.in.web.dto.request;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PositiveOrZero;
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
  private List<ProductInfoRequest> productInfo;

  @Schema(description = "배달 주소")
  @NotBlank
  private String deliveryAddress;

  @Schema(description = "연락처")
  @NotBlank
  private String phoneNumber;

  @Schema(description = "결제 정보")
  @NotNull
  private PaymentInfo paymentInfo;

  @Schema(description = "배달 금액")
  @PositiveOrZero
  private int deliveryAmount;

}
