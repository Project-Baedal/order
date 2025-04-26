package com.baedal.order.application.port.in;

import com.baedal.order.application.command.AddOrderCommand;
import com.baedal.order.application.command.OrderValidateCommand;

public interface OrderUseCase {

  // 주문 등록
  AddOrderCommand.Response addOrder(AddOrderCommand.Request req);

  // 주문 검증
  void orderValidate(OrderValidateCommand.Request req);
}
