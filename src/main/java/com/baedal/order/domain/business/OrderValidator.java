package com.baedal.order.domain.business;

import com.baedal.order.application.command.AddOrderCommand;
import com.baedal.order.domain.store.Store;


public class OrderValidator {

  public void checkDeliveryAmountMatches(AddOrderCommand.Request req, Store store) {
    if (req.getDeliveryAmount() != store.getDeliveryAmount())
      throw new RuntimeException("배달비가 잘못되었거나 변경되었습니다.");
  }
}
