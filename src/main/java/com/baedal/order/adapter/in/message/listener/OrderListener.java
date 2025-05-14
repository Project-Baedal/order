package com.baedal.order.adapter.in.message.listener;

import com.baedal.order.adapter.in.message.dto.OrderValidateRequest;
import com.baedal.order.adapter.in.message.mapper.OrderListenerMapper;
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


  @KafkaListener(topics = "order.orderCancel", groupId = "order-cancel-group")
  public void orderCancel(ConsumerRecord<String, String> record) {
    Long orderId = Long.valueOf(record.key());
    orderUseCase.orderCancel(orderId);
  }


}
