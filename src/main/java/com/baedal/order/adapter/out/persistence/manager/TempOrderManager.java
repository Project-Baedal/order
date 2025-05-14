package com.baedal.order.adapter.out.persistence.manager;

import com.baedal.order.adapter.out.persistence.dto.SaveTempOrderDto;
import com.baedal.order.adapter.out.persistence.repository.OrderRedisRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class TempOrderManager {

  private final String PREFIX = "tempOrder:";

  private final OrderRedisRepository orderRedisRepository;

  private String getKey(String key) {
    return PREFIX + key;
  }


  public void saveTempOrder(String orderTransactionId, SaveTempOrderDto dto) {
    String key = getKey(orderTransactionId);
    orderRedisRepository.save(key, dto);
  }
}
