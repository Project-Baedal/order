package com.baedal.order.adapter.out.persistence.dto;

import java.util.List;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class SaveTempOrderDto {
  private Long customerId;
  private Long storeId;
  private List<ProductInfoDto> productIds;
  private String deliveryAddress;
  private String phoneNumber;
  private PaymentInfoDto paymentInfo;
  private int deliveryAmount;
}
