package com.baedal.order.adapter.out.persistence.adapter;

import com.baedal.order.adapter.out.persistence.manager.OrderCacheCreator;
import com.baedal.order.application.port.out.OrderCacheRepositoryPort;
import java.util.UUID;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class OrderCacheRepositoryAdapter implements OrderCacheRepositoryPort {

  private final OrderCacheCreator orderCacheCreator;
  @Override
  public String generateAndSaveOrderTransactionId() {
    String orderTransactionId = UUID.randomUUID().toString();
    orderCacheCreator.saveOrderTransactionId(orderTransactionId);
    return orderTransactionId;
  }
}
