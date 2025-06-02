package com.baedal.order.domain.model.rider;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class AddRiderQueueRequest {

  private Long orderId;
}
