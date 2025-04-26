package com.baedal.order.adapter.out.persistence.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class OrderValidateDto {

  private String domain;
  private boolean status;
  private String message;

}
