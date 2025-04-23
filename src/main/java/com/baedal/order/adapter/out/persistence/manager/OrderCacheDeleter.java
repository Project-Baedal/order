package com.baedal.order.adapter.out.persistence.manager;

import com.baedal.order.adapter.out.persistence.dto.OrderValidateDto;
import com.baedal.order.adapter.out.persistence.repository.OrderRedisRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class OrderCacheDeleter {

  private final OrderRedisRepository orderRedisRepository;

  public void deleteKey(String orderTransactionId) {
    orderRedisRepository.deleteKey(orderTransactionId);
  }
}
