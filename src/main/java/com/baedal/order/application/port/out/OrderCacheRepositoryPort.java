package com.baedal.order.application.port.out;

import com.baedal.order.domain.model.SuccessOrderValidate;
import java.util.Set;

public interface OrderCacheRepositoryPort {

  void successOrderValidate(SuccessOrderValidate req);

  Set<String> getOrderValidationStatus(String orderTransactionId);
}
