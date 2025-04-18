package com.baedal.order.adapter.out.persistence.adapter;

import com.baedal.order.adapter.out.persistence.entity.OrderEntity;
import com.baedal.order.adapter.out.persistence.manager.OrderCreator;
import com.baedal.order.adapter.out.persistence.mapper.OrderPersistenceMapper;
import com.baedal.order.application.port.out.OrderRepositoryPort;
import com.baedal.order.domain.model.AddOrder;
import com.baedal.order.domain.model.Order;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class OrderRepositoryAdapter implements OrderRepositoryPort {

  private final OrderPersistenceMapper orderMapper;
  private final OrderCreator orderCreator;

  @Override
  public Order save(AddOrder addOrder) {
    OrderEntity entity = orderMapper.toEntity(addOrder);
    orderCreator.save(entity);
    return orderMapper.toDomain(entity);
  }
}
