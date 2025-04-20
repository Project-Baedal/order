package com.baedal.order.adapter.out.persistence.manager;

import com.baedal.order.adapter.out.persistence.repository.OrderRedisRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class OrderCacheCreator {

  private final OrderRedisRepository orderRedisRepository;

  public void saveOrderTransactionId(String orderTransactionId) {
    String key = "order:" + orderTransactionId;
    orderRedisRepository.save(key, "order", "true");
  }
}
