package com.baedal.order.domain.model;

import com.baedal.order.adapter.out.persistence.dto.ProductInfoDto;
import java.util.List;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class TempOrder {

  private Long customerId;
  private Long storeId;
  private List<ProductInfoDto> productIds;
  private String deliveryAddress;
  private String phoneNumber;
}