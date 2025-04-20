package com.baedal.order.adapter.out.persistence.adapter;

import com.baedal.order.application.port.out.OrderCacheRepositoryPort;
import java.util.UUID;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class OrderCacheRepositoryAdapter implements OrderCacheRepositoryPort {

  @Override
  public String generateAndSaveOrderTransactionId() {
    String orderTransactionId = UUID.randomUUID().toString();
    return orderTransactionId;
  }
}
