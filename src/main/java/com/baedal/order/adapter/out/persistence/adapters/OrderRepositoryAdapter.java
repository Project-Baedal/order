package com.baedal.order.adapter.out.persistence.adapters;

import com.baedal.order.adapter.out.persistence.entity.OrderEntity;
import com.baedal.order.adapter.out.persistence.manager.OrderCreator;
import com.baedal.order.adapter.out.persistence.manager.OrderReader;
import com.baedal.order.adapter.out.persistence.mapper.OrderPersistenceMapper;
import com.baedal.order.application.port.out.OrderRepositoryPort;
import com.baedal.order.domain.model.AddOrder;
import com.baedal.order.domain.model.Order;
import com.baedal.order.domain.model.OrderStatus;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class OrderRepositoryAdapter implements OrderRepositoryPort {

  private final OrderPersistenceMapper orderMapper;
  private final OrderCreator orderCreator;
  private final OrderReader orderReader;

  @Override
  public Order save(AddOrder addOrder) {
    OrderEntity entity = orderMapper.toEntity(addOrder);
    orderCreator.save(entity);
    return orderMapper.toDomain(entity);
  }

  @Override
  public Order findById(Long id) {
    OrderEntity entity = orderReader.findById(id);
    return orderMapper.toDomain(entity);
  }

  @Override
  public void cancelOrderById(Order order) {
    order.updatedOrderStatus(OrderStatus.CANCELLED);
    OrderEntity entity = orderMapper.toEntity(order);
    orderCreator.save(entity);
  }
}
