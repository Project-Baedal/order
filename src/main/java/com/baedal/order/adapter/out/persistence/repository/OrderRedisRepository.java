package com.baedal.order.adapter.out.persistence.repository;

import java.util.Set;
import lombok.RequiredArgsConstructor;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class OrderRedisRepository {

  private final RedisTemplate<String, Object> redisTemplate;

  public void save(String key, Object value) {
    redisTemplate.opsForSet().add(key, value);
  }

  public Set<Object> getKeys(String key) {
    return redisTemplate.opsForSet().members(key);
  }
}
