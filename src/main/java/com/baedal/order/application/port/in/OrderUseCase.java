package com.baedal.order.application.port.in;

import com.baedal.order.application.command.AddOrderCommand;

public interface OrderUseCase {

  // 주문 등록
  AddOrderCommand.Response addOrder(AddOrderCommand.Request req);
}
