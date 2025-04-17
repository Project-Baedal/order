package com.baedal.order.adapter.in.web.mapper;

import com.baedal.order.adapter.in.web.dto.request.AddOrderRequest;
import com.baedal.order.adapter.in.web.dto.response.AddOrderResponse;
import com.baedal.order.application.command.AddOrderCommand;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface OrderWebMapper {

  // 주문 등록
  AddOrderCommand.Request addOrderToCommand(Long customerId, AddOrderRequest addOrderRequest);
  AddOrderResponse addOrderToResponse(AddOrderCommand.Response addOrderResponse);

}
