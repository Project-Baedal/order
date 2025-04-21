package com.baedal.order.domain.business;

import java.util.concurrent.Future;

public class FutureManager {

  public <T> T extract(Future<T> future) {
    try {
      return future.get();
    } catch (Exception e) {
      throw new RuntimeException("Future 값 추출에 실패하였습니다.", e);
    }
  }
}
