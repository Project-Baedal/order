package com.baedal.order.application.port.out;

import com.baedal.order.domain.model.AddOrderValidate;
import com.baedal.order.domain.model.ValidateResult;
import java.util.Set;

public interface OrderCacheRepositoryPort {

  void addOrderValidate(AddOrderValidate req);

  Set<ValidateResult> getOrderValidationStatus(String orderTransactionId);
}
