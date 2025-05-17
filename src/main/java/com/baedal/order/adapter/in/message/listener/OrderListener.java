package com.baedal.order.adapter.in.message.listener;

import com.baedal.order.adapter.in.message.dto.OrderSuccessRequest;
import com.baedal.order.adapter.in.message.dto.OrderValidateRequest;
import com.baedal.order.adapter.in.message.mapper.OrderListenerMapper;
import com.baedal.order.application.command.OrderSuccessCommand;
import com.baedal.order.application.command.OrderValidateCommand;
import com.baedal.order.application.port.in.OrderUseCase;
import com.baedal.order.util.Converter;
import lombok.RequiredArgsConstructor;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class OrderListener {

  private final Converter converter;
  private final OrderListenerMapper mapper;
  private final OrderUseCase orderUseCase;


  @KafkaListener(topics = "order.orderValidate", groupId = "order-validate-group")
  public void orderValidate(ConsumerRecord<String, String> record) {
    String orderTransactionId = record.key();
    OrderValidateRequest req = converter.jsonToDto(record.value(), OrderValidateRequest.class);
    OrderValidateCommand.Request command = mapper.orderValidateToCommand(orderTransactionId, req);
    orderUseCase.orderValidate(command);
  }

  @KafkaListener(topics = "order.orderSuccess", groupId = "order-validate-group")
  public void orderSuccess(ConsumerRecord<String, String> record) {
    OrderSuccessRequest req = converter.jsonToDto(record.value(), OrderSuccessRequest.class);
    OrderSuccessCommand.Request command = mapper.orderSuccessToCommand(req);
    orderUseCase.orderSuccess(command);
  }

}
