package com.baedal.order.domain.business;

import java.util.Set;
import org.springframework.stereotype.Component;

@Component
public class OrderValidate {

  // 검증 해야 하는 도메인 갯수
  private final int COUNT = 4;

  public boolean validate(Set<String> domains, String domain) {
    domains.add(domain);
    return domains.size() >= COUNT;
  }
}
