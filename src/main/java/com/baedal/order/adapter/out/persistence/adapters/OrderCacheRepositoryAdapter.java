package com.baedal.order.adapter.out.persistence.adapters;

import com.baedal.order.adapter.out.persistence.manager.OrderCacheCreator;
import com.baedal.order.adapter.out.persistence.manager.OrderCacheReader;
import com.baedal.order.application.port.out.OrderCacheRepositoryPort;
import com.baedal.order.domain.model.SuccessOrderValidate;
import java.util.Set;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class OrderCacheRepositoryAdapter implements OrderCacheRepositoryPort {

  private final OrderCacheCreator orderCacheCreator;
  private final OrderCacheReader orderCacheReader;

  @Override
  public void successOrderValidate(SuccessOrderValidate req) {
    orderCacheCreator.saveOrderTransactionId(req.getOrderTransactionId(), req.getDomain());
  }

  @Override
  public Set<String> getOrderValidationStatus(String orderTransactionId) {
    return orderCacheReader.findByOrderTransactionId(orderTransactionId);
  }

}
