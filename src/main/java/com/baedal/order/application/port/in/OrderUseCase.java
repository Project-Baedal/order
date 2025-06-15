package com.baedal.order.application.port.in;

import com.baedal.order.application.command.AddOrderCommand;
import com.baedal.order.application.command.CancelExpiredOrderCommand;
import com.baedal.order.application.command.OrderSuccessCommand;
import com.baedal.order.application.command.OrderValidateCommand;

public interface OrderUseCase {

  // 주문 등록
  AddOrderCommand.Response addOrder(AddOrderCommand.Request req);

  // 주문 검증
  void orderValidate(OrderValidateCommand.Request req);

  void confirmOrder(Long orderId);

  void cancelOrder(Long orderId);

  // 주문 취소
  void orderCancel(Long orderId);

  // 주문 성공
  void orderSuccess(OrderSuccessCommand.Request req);

  // 만료 주문 취소
  void cancelExpiredOrder(CancelExpiredOrderCommand.Request req);
}
