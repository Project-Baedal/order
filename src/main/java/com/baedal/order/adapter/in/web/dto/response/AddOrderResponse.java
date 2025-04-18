package com.baedal.order.adapter.in.web.dto.response;

import io.swagger.v3.oas.annotations.media.Schema;
import java.time.LocalDateTime;
import java.util.List;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class AddOrderResponse {

  @Schema(description = "상태 값 (결제 대기/승인 대기/상품 준비/픽업 준비/픽업 중/배달 완료")
  private String orderStatus;

  @Schema(description = "매장명")
  private String storeName;

  @Schema(description = "주문일시")
  private LocalDateTime orderDate;

  @Schema(description = "주문번호")
  private Long orderId;

  @Schema(description = "상품 정보")
  private List<AddOrderProductInfo> productInfo;

  @Schema(description = "총 금액")
  private int totalAmount;

  @Schema(description = "메뉴 금액")
  private int totalProductAmount;

  @Schema(description = "배달 금액")
  private int deliveryAmount;

  @Schema(description = "결제 방법")
  private String paymentMethod;

  @Schema(description = "배달 주소")
  private String deliveryAddress;

  @Schema(description = "연락처")
  private String phoneNumber;


}
