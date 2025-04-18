package com.baedal.order.application.port.out;

import com.baedal.order.application.command.AddOrderCommand;

public interface MessageSenderPort {

  void sendPaymentRequest(Long orderId, AddOrderCommand.PaymentInfo req);
}
