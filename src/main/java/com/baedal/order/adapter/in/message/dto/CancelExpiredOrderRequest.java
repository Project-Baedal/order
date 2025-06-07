package com.baedal.order.adapter.in.message.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import java.time.LocalDateTime;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class CancelExpiredOrderRequest {

  @Schema(description = "주문 ID")
  private String orderTransactionId;

  @Schema(description = "처리 시간")
  private LocalDateTime expiredAt;

}
