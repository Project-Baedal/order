package com.baedal.order.adapter.out.messaging;

import com.baedal.order.application.command.AddOrderCommand.PaymentInfo;
import com.baedal.order.application.port.out.MessageSenderPort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

// note. 이후 Topic 은 SecretKey 로 관리, Key/Value 는 암호화 고려해보면 좋을 것같습니다.
@Component
@RequiredArgsConstructor
public class MessageSenderAdapter implements MessageSenderPort {

  private final KafkaSender kafkaSender;

  @Override
  public void sendPaymentRequest(Long orderId, PaymentInfo req) {
    kafkaSender.sendMessage("payment.paymentRequest", orderId.toString(), req);
  }
}
