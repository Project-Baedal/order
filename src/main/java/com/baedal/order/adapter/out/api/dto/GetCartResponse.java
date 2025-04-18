package com.baedal.order.adapter.out.api.dto;

import java.util.List;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class GetCartResponse {

  private Long storeId;
  private List<Long> productIds;
}
