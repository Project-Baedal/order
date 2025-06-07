package com.baedal.order.domain.business;

import com.baedal.order.domain.model.OrderValidationType;
import com.baedal.order.domain.model.ValidateResult;
import java.util.Arrays;
import java.util.Set;
import java.util.stream.Collectors;

public class OrderExtractor {

  public String validateFailDomain(Set<ValidateResult> results) {
    Set<String> existingDomains = results.stream()
        .map(ValidateResult::getDomain)
        .collect(Collectors.toSet());

    return Arrays.stream(OrderValidationType.values())
        .map(Enum::name)
        .filter(domain -> !existingDomains.contains(domain))
        .findFirst()
        .orElse(null);
  }

}
