package com.baedal.order.application.port.out;

import com.baedal.order.application.command.AddOrderCommand;
import com.baedal.order.domain.model.TempOrder;

public interface OrderTempCacheRepositoryPort {

  void saveTempOrder(String orderTransactionId, AddOrderCommand.Request req);

  TempOrder getTempOrder(String orderTransactionId);
  TempOrder findByTransactionId(String transactionId);
}
