package com.baedal.order.adapter.out.persistence.adapters;

import com.baedal.order.adapter.out.persistence.dto.OrderValidateDto;
import com.baedal.order.adapter.out.persistence.manager.ValidateOrderManager;
import com.baedal.order.adapter.out.persistence.mapper.OrderPersistenceMapper;
import com.baedal.order.application.port.out.OrderValidateCacheRepositoryPort;
import com.baedal.order.domain.model.AddOrderValidate;
import com.baedal.order.domain.model.ValidateResult;
import java.util.Set;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class OrderValidateCacheRepositoryAdapter implements OrderValidateCacheRepositoryPort {

  private final ValidateOrderManager validateOrderManager;
  private final OrderPersistenceMapper orderMapper;

  @Override
  public void addOrderValidate(AddOrderValidate req) {
    OrderValidateDto dto = orderMapper.addOrderValidateToDto(req);
    validateOrderManager.saveOrderTransactionId(req.getOrderTransactionId(), dto);
  }

  @Override
  public Set<ValidateResult> getOrderValidationStatus(String orderTransactionId) {
    Set<OrderValidateDto> response = validateOrderManager.findByOrderTransactionId(
        orderTransactionId
    );
    return orderMapper.getOrderValidateToDomain(response);
  }

  @Override
  public void deleteKey(String orderTransactionId) {
    validateOrderManager.deleteKey(orderTransactionId);
  }

}
