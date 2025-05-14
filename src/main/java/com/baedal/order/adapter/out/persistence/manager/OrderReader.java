package com.baedal.order.adapter.out.persistence.manager;

import com.baedal.order.adapter.out.persistence.entity.OrderEntity;
import com.baedal.order.adapter.out.persistence.repository.OrderJpaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class OrderReader {

  private final OrderJpaRepository orderJpaRepository;

  public OrderEntity findById(Long id) {
    return orderJpaRepository.findById(id).orElseThrow(() ->
        new RuntimeException("해당 ID 값을 가진 데이터가 존재하지 않거나 접근 권한이 없습니다.")
    );

  }

}
