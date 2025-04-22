package com.baedal.order.adapter.out.messaging;

import com.baedal.order.application.port.out.MessageSenderPort;
import com.baedal.order.domain.model.cart.ValidateCartOrderInfo;
import com.baedal.order.domain.model.product.ValidateProductOrderInfo;
import com.baedal.order.domain.model.store.ValidateStoreOrderInfo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

// note. 이후 Topic 은 SecretKey 로 관리, Key/Value 는 암호화 고려해보면 좋을 것같습니다.
@Component
@RequiredArgsConstructor
public class MessageSenderAdapter implements MessageSenderPort {

  private final KafkaSender kafkaSender;

  @Override
  public void validateCartOrderInfo(ValidateCartOrderInfo.Request req) {
    kafkaSender.sendMessage("cart.validateCartOrderInfo", req.getOrderTransactionId(), req);
  }

  @Override
  public void validateProductOrderInfo(ValidateProductOrderInfo.Request req) {
    kafkaSender.sendMessage("cart.validateProductOrderInfo", req.getOrderTransactionId(),req);
  }

  @Override
  public void validateStoreOrderInfo(ValidateStoreOrderInfo.Request req) {
    kafkaSender.sendMessage("cart.validateStoreOrderInfo", req.getOrderTransactionId(), req);
  }

  @Override
  public void approvePayment(String orderTransactionId) {
    kafkaSender.sendMessage("payment.approvePayment", orderTransactionId, null);

  }

}
