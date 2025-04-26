package com.baedal.order.adapter.out.persistence.manager;

import com.baedal.order.adapter.out.persistence.dto.OrderValidateDto;
import com.baedal.order.adapter.out.persistence.repository.OrderRedisRepository;
import java.util.Set;
import java.util.stream.Collectors;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class OrderCacheReader {

  private final OrderRedisRepository orderRedisRepository;

  public Set<OrderValidateDto> findByOrderTransactionId(String orderTransactionId) {
    Set<Object> set = orderRedisRepository.getKeys(orderTransactionId);
    return set.stream()
        .map(obj -> (OrderValidateDto) obj)
        .collect(Collectors.toSet());
  }
}
