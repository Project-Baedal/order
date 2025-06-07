package com.baedal.order.domain.business;

import java.time.Duration;
import java.time.LocalDateTime;

public class OrderCalculator {

  public long millisSinceNow(LocalDateTime pastTime) {
    LocalDateTime now = LocalDateTime.now();
    return Duration.between(pastTime, now).toMillis();
  }


}
