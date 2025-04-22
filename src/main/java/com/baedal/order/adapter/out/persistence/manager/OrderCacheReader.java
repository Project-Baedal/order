package com.baedal.order.adapter.out.persistence.manager;

import com.baedal.order.adapter.out.persistence.dto.GetOrderValidateResponse;
import com.baedal.order.adapter.out.persistence.repository.OrderRedisRepository;
import java.util.Set;
import java.util.stream.Collectors;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class OrderCacheReader {

  private final OrderRedisRepository orderRedisRepository;

  public Set<GetOrderValidateResponse> findByOrderTransactionId(String orderTransactionId) {
    return orderRedisRepository.getKeys(orderTransactionId).stream()
        .map(obj -> (GetOrderValidateResponse) obj)
        .collect(Collectors.toSet());
  }
}
