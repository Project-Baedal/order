package com.baedal.order.adapter.out.persistence.repository;

import java.util.Set;
import lombok.RequiredArgsConstructor;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class OrderRedisRepository {

  private final RedisTemplate<String, Object> redisTemplate;


  public void saveSet(String key, Object value) {
    redisTemplate.opsForSet().add(key, value);
  }

  public void saveObject(String key, Object value) {
    redisTemplate.opsForValue().set(key, value);
  }

  public Set<Object> getKeys(String key) {
    return redisTemplate.opsForSet().members(key);
  }

  public Object getKey(String key) {
    return redisTemplate.opsForValue().get(key);
  }


  public void deleteKey(String key) {
    redisTemplate.delete(key);
  }
}
