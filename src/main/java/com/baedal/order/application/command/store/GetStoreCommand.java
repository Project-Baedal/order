package com.baedal.order.application.command.store;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class GetStoreCommand {

  private String storeName;
  private int deliveryAmount;

}
