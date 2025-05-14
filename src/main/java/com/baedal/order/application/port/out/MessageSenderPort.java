package com.baedal.order.application.port.out;

import com.baedal.order.domain.model.cart.ValidateCartOrderInfo;
import com.baedal.order.domain.model.product.ValidateProductOrderInfo;
import com.baedal.order.domain.model.store.ValidateStoreOrderInfo;

public interface MessageSenderPort {

  void validateCartOrderInfo(ValidateCartOrderInfo.Request req);

  void validateProductOrderInfo(ValidateProductOrderInfo.Request req);

  void validateStoreOrderInfo(ValidateStoreOrderInfo.Request req);

  void approvePayment(String orderTransactionId);

  void failOrder(String orderTransactionId, String errorMessage);

  void cancelPayment(Long paymentId);
}
