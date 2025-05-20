package com.baedal.order.adapter.out.persistence.manager;

import com.baedal.order.adapter.out.persistence.entity.OrderEntity;
import com.baedal.order.adapter.out.persistence.repository.OrderJpaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class OrderReader {

  private final OrderJpaRepository repository;

  public OrderEntity findById(Long id) {
    return repository.findById(id)
        .orElseThrow(() -> new RuntimeException("Failed to find OrderEntity by id."));
  }
}
