package com.baedal.order.adapter.out.persistence.adapters;

import com.baedal.order.adapter.out.persistence.dto.SaveTempOrderDto;
import com.baedal.order.adapter.out.persistence.manager.TempOrderManager;
import com.baedal.order.adapter.out.persistence.mapper.OrderPersistenceMapper;
import com.baedal.order.application.command.AddOrderCommand;
import com.baedal.order.application.port.out.OrderTempCacheRepositoryPort;
import com.baedal.order.domain.model.TempOrder;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class OrderTempCacheRepositoryAdapter implements OrderTempCacheRepositoryPort {

  private final OrderPersistenceMapper orderMapper;
  private final TempOrderManager tempOrderManager;

  @Override
  public void saveTempOrder(String orderTransactionId, AddOrderCommand.Request req) {
    SaveTempOrderDto dto = orderMapper.saveTempOrderToDto(req);
    tempOrderManager.saveTempOrder(orderTransactionId, dto);
  }

  @Override
  public TempOrder getTempOrder(String orderTransactionId) {
    SaveTempOrderDto dto = tempOrderManager.getTempOrder(orderTransactionId);
    return orderMapper.toDomain(dto);
  }

  @Override
  public TempOrder findByTransactionId(String transactionId) {
    SaveTempOrderDto dto = tempOrderManager.getTempOrder(transactionId);
    return orderMapper.saveTempOrderToTempOrder(dto);
  }

}
