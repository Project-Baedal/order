package com.baedal.order.adapter.out.persistence.adapters;

import com.baedal.order.adapter.out.persistence.entity.OrderEntity;
import com.baedal.order.adapter.out.persistence.manager.OrderCreator;
import com.baedal.order.adapter.out.persistence.manager.OrderReader;
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

  private final OrderReader reader;

  @Override
  public Order save(AddOrder addOrder) {
    OrderEntity entity = orderMapper.toEntity(addOrder);
    orderCreator.save(entity);
    return orderMapper.toDomain(entity);
  }

  @Override
  public Order findById(Long id) {
    OrderEntity entity = reader.findById(id);
    return orderMapper.toDomain(entity);
  }
}
