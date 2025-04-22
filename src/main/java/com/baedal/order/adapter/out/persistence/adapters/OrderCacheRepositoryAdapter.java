package com.baedal.order.adapter.out.persistence.adapters;

import com.baedal.order.adapter.out.persistence.dto.AddOrderValidateRequest;
import com.baedal.order.adapter.out.persistence.dto.GetOrderValidateResponse;
import com.baedal.order.adapter.out.persistence.manager.OrderCacheCreator;
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
  private final OrderPersistenceMapper orderMapper;

  @Override
  public void addOrderValidate(AddOrderValidate req) {
    AddOrderValidateRequest dto = orderMapper.addOrderValidateToDto(req);
    orderCacheCreator.saveOrderTransactionId(req.getOrderTransactionId(), dto);
  }

  @Override
  public Set<ValidateResult> getOrderValidationStatus(String orderTransactionId) {
    Set<GetOrderValidateResponse> response = orderCacheReader.findByOrderTransactionId(
        orderTransactionId
    );
    return orderMapper.getOrderValidateToDomain(response);
  }

}
