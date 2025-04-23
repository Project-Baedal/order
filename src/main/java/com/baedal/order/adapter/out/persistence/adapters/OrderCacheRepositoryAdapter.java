package com.baedal.order.adapter.out.persistence.adapters;

import com.baedal.order.adapter.out.persistence.dto.OrderValidateDto;
import com.baedal.order.adapter.out.persistence.manager.OrderCacheCreator;
import com.baedal.order.adapter.out.persistence.manager.OrderCacheDeleter;
import com.baedal.order.adapter.out.persistence.manager.OrderCacheReader;
import com.baedal.order.adapter.out.persistence.mapper.OrderPersistenceMapper;
import com.baedal.order.application.port.out.OrderCacheRepositoryPort;
import com.baedal.order.domain.model.AddOrderValidate;
import com.baedal.order.domain.model.ValidateResult;
import java.util.Set;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class OrderCacheRepositoryAdapter implements OrderCacheRepositoryPort {

  private final OrderCacheCreator orderCacheCreator;
  private final OrderCacheReader orderCacheReader;
  private final OrderCacheDeleter orderCacheDeleter;
  private final OrderPersistenceMapper orderMapper;

  @Override
  public void addOrderValidate(AddOrderValidate req) {
    OrderValidateDto dto = orderMapper.addOrderValidateToDto(req);
    orderCacheCreator.saveOrderTransactionId(req.getOrderTransactionId(), dto);
  }

  @Override
  public Set<ValidateResult> getOrderValidationStatus(String orderTransactionId) {
    Set<OrderValidateDto> response = orderCacheReader.findByOrderTransactionId(
        orderTransactionId
    );
    return orderMapper.getOrderValidateToDomain(response);
  }

  @Override
  public void deleteKey(String orderTransactionId) {
    orderCacheDeleter.deleteKey(orderTransactionId);
  }

}
