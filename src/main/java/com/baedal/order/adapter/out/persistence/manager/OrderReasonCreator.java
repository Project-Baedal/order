package com.baedal.order.adapter.out.persistence.manager;

import com.baedal.order.adapter.out.persistence.entity.OrderReasonEntity;
import com.baedal.order.adapter.out.persistence.repository.OrderReasonJpaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
public class OrderReasonCreator {

  private final OrderReasonJpaRepository orderReasonJpaRepository;

  public OrderReasonEntity save(OrderReasonEntity orderReasonEntity) {
    return orderReasonJpaRepository.save(orderReasonEntity);
  }
}
