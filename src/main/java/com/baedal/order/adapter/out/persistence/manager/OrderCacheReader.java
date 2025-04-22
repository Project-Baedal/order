package com.baedal.order.adapter.out.persistence.manager;

import com.baedal.order.adapter.out.persistence.repository.OrderRedisRepository;
import java.util.Set;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class OrderCacheReader {

  private final OrderRedisRepository orderRedisRepository;

  public Set<String> findByOrderTransactionId(String orderTransactionId) {
    return orderRedisRepository.getKeys(orderTransactionId);
  }
}
