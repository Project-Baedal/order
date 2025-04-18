package com.baedal.order.adapter.out.persistence.manager;

import com.baedal.order.adapter.out.persistence.entity.OrderEntity;
import com.baedal.order.adapter.out.persistence.repository.OrderJpaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class OrderCreator {

  private final OrderJpaRepository orderJpaRepository;

  public OrderEntity save(OrderEntity orderEntity) {
    return orderJpaRepository.save(orderEntity);
  }

}
