package com.baedal.order.adapter.out.persistence.manager;

import com.baedal.order.adapter.out.persistence.dto.OrderValidateDto;
import com.baedal.order.adapter.out.persistence.repository.OrderRedisRepository;
import java.util.Set;
import java.util.stream.Collectors;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class ValidateOrderManager {

  private final String PREFIX = "validateOrder:";

  private final OrderRedisRepository orderRedisRepository;

  private String getKey(String key) {
    return PREFIX + key;
  }

  public void saveOrderTransactionId(String orderTransactionId, OrderValidateDto dto) {
    String key = getKey(orderTransactionId);
    orderRedisRepository.saveSet(key, dto);
  }

  public Set<OrderValidateDto> findByOrderTransactionId(String orderTransactionId) {
    String key = getKey(orderTransactionId);
    Set<Object> set = orderRedisRepository.getKeys(key);
    return set.stream()
        .map(obj -> (OrderValidateDto) obj)
        .collect(Collectors.toSet());
  }

  public void deleteKey(String orderTransactionId) {
    String key = getKey(orderTransactionId);
    orderRedisRepository.deleteKey(key);
  }

}
