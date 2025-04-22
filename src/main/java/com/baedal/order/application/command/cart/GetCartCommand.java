package com.baedal.order.application.command.cart;

import java.util.List;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class GetCartCommand {

  private Long storeId;
  private List<Long> productIds;
}
