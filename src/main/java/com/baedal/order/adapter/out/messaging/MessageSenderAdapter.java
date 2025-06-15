package com.baedal.order.adapter.out.messaging;

import com.baedal.order.application.command.store.RequestStoreOrderCommand.Request;
import com.baedal.order.application.port.out.MessageSenderPort;
import com.baedal.order.domain.model.FailOrder;
import com.baedal.order.domain.model.cart.ValidateCartOrderInfo;
import com.baedal.order.domain.model.product.ValidateProductOrderInfo;
import com.baedal.order.domain.model.rider.AddRiderQueueRequest;
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
    kafkaSender.sendMessage("product.validateProductOrderInfo", req.getOrderTransactionId(), req);
  }

  @Override
  public void validateStoreOrderInfo(ValidateStoreOrderInfo.Request req) {
    kafkaSender.sendMessage("store.validateStoreOrderInfo", req.getOrderTransactionId(), req);
  }

  @Override
  public void approvePayment(String orderTransactionId) {
    kafkaSender.sendMessage("payment.approvePayment", orderTransactionId, null);

  }

  @Override
  public void failOrder(String orderTransactionId, String errorMessage) {
    kafkaSender.sendMessage("payment.failOrder", orderTransactionId, errorMessage);
  }

  @Override
  public void orderAccepted_addRiderQueue(Long orderId, AddRiderQueueRequest req) {
    // FIXME: rider or delivery domain 에서 받을 지 정하고 수정해야 함
    kafkaSender.sendMessage("rider.addRiderQueue", orderId.toString(), req);
  }
  @Override
  public void cancelPayment(Long paymentId) {
    kafkaSender.sendMessage("payment.cancelPayment", paymentId.toString(), paymentId);
  }

  @Override
  public void requestStoreOrder(Request req) {
    String key = req.getStoreId().toString();
    kafkaSender.sendMessage("payment.requestStoreOrder", key, req);
  }

  @Override
  public void failOrder(FailOrder.Request req) {
    kafkaSender.sendMessage("order.failOrder", req.getOrderTransactionId(), req);
  }

}
