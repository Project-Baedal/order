package com.baedal.order.application.port.out;

import com.baedal.order.application.command.AddOrderCommand;

public interface OrderTempCacheRepositoryPort {

  void saveTempOrder(String orderTransactionId, AddOrderCommand.Request req);

}
