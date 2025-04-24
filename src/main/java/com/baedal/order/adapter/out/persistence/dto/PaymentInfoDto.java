package com.baedal.order.adapter.out.persistence.dto;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class PaymentInfoDto {
  private String paymentMethod;
  private int totalAmount;
}