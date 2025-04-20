package com.baedal.order.adapter.out.persistence.repository;

import lombok.RequiredArgsConstructor;
import org.springframework.data.redis.core.HashOperations;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class OrderRedisRepository {

  private final HashOperations<String, String, String> hashOps;

  public void save(String key, String field, String value) {
    hashOps.put(key, field, value);
  }
}
