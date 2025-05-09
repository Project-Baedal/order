package com.baedal.order.adapter.in.web.controller;

import com.baedal.order.adapter.in.web.dto.request.AddOrderRequest;
import com.baedal.order.adapter.in.web.dto.response.AddOrderResponse;
import com.baedal.order.adapter.in.web.dto.response.GetOrderResponse;
import com.baedal.order.adapter.in.web.mapper.OrderWebMapper;
import com.baedal.order.adapter.out.persistence.enums.OrderEntityStatus;
import com.baedal.order.application.command.AddOrderCommand;
import com.baedal.order.application.port.in.OrderUseCase;
import com.baedal.order.application.service.OrderQueryService;
import com.baedal.order.domain.model.Order;
import com.baedal.order.domain.model.OrderStatus;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/order/v0")
@RequiredArgsConstructor
public class OrderController {

  private final OrderWebMapper mapper;

  private final OrderUseCase orderUseCase;

  private final OrderQueryService orderQueryService;

  @PostMapping("/")
  public ResponseEntity<AddOrderResponse> addOrder(@Valid @RequestBody AddOrderRequest req) {
    // note. 인증/인가 코드 작성 이후 변경 예정
    Long customerId = 1L;
    AddOrderCommand.Request commandRequest = mapper.addOrderToCommand(customerId, req);
    AddOrderCommand.Response commandResponse = orderUseCase.addOrder(commandRequest);
    AddOrderResponse response = mapper.addOrderToResponse(commandResponse);
    return ResponseEntity.ok(response);
  }

  @GetMapping("/{orderId}")
  public ResponseEntity<GetOrderResponse> getOrder(@PathVariable Long orderId) {
    Order order = orderQueryService.findOrderByOrderId(orderId);
    GetOrderResponse response = mapper.getOrderToResponse(order);
    return ResponseEntity.ok(response);
  }

  @PatchMapping("/{orderId}")
  public ResponseEntity<Void> changeOrderStatus(
      @PathVariable Long orderId,
      @RequestParam(name = "status") OrderStatus status) {
    orderUseCase.changeOrderStatus(orderId, status);
    return ResponseEntity.noContent().build();
  }
}
