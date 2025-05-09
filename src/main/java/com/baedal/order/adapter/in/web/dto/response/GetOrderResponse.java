package com.baedal.order.adapter.in.web.dto.response;

import com.baedal.order.domain.model.OrderStatus;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class GetOrderResponse {

  private Long orderId;

  private Long storeId;

  private OrderStatus orderStatus;
}
