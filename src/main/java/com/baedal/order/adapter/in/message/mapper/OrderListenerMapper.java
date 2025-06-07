package com.baedal.order.adapter.in.message.mapper;

import com.baedal.order.adapter.in.message.dto.CancelExpiredOrderRequest;
import com.baedal.order.adapter.in.message.dto.OrderSuccessRequest;
import com.baedal.order.adapter.in.message.dto.OrderValidateRequest;
import com.baedal.order.application.command.CancelExpiredOrderCommand;
import com.baedal.order.application.command.OrderSuccessCommand;
import com.baedal.order.application.command.OrderValidateCommand;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface OrderListenerMapper {

  // 주문 검증
  OrderValidateCommand.Request orderValidateToCommand(
      String orderTransactionId, OrderValidateRequest req
  );

  // 주문 성공
  OrderSuccessCommand.Request orderSuccessToCommand(OrderSuccessRequest req);

  // 만료 주문 취소
  CancelExpiredOrderCommand.Request cancelExpiredOrderToCommand(CancelExpiredOrderRequest req);
}
