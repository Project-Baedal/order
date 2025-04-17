package com.baedal.order.adapter.in.web.controller;

import com.baedal.order.adapter.in.web.dto.request.AddOrderRequest;
import com.baedal.order.adapter.in.web.dto.response.AddOrderResponse;
import com.baedal.order.adapter.in.web.mapper.OrderWebMapper;
import com.baedal.order.application.command.AddOrderCommand;
import com.baedal.order.application.port.in.OrderUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/order")
@RequiredArgsConstructor
public class OrderController {

  private final OrderWebMapper mapper;
  private final OrderUseCase orderUseCase;

  @PostMapping("/")
  public ResponseEntity<AddOrderResponse> addOrder(@RequestBody AddOrderRequest req) {
    // note. 인증/인가 코드 작성 이후 변경 예정
    Long customerId = 1L;
    AddOrderCommand.Request commandRequest = mapper.addOrderToCommand(customerId, req);
    AddOrderCommand.Response commandResponse = orderUseCase.addOrder(commandRequest);
    AddOrderResponse response = mapper.addOrderToResponse(commandResponse);
    return ResponseEntity.ok(response);
  }
}
