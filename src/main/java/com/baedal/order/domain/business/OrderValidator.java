package com.baedal.order.domain.business;

import com.baedal.order.domain.model.Order;
import com.baedal.order.domain.model.OrderStatus;
import com.baedal.order.domain.model.ValidateResult;
import java.util.Optional;
import java.util.Set;
import org.springframework.stereotype.Component;

@Component
public class OrderValidator {

  // 검증 해야 하는 도메인 갯수
  private final int COUNT = 4;


  public boolean validateCount(Set<ValidateResult> domains) {
    return domains.size() >= COUNT;
  }

  public Optional<String> getErrorMessage(Set<ValidateResult> results) {
    return results.stream()
        .filter(result -> !result.isStatus())
        .map(ValidateResult::getMessage)
        .findFirst();
  }

  public void validateSucceededStatus(Order order) {
    if (order.getOrderStatus() != OrderStatus.SUCCEEDED) {
      throw new RuntimeException("주문 상태가 일치하지 않습니다.");
    }
  }


}
