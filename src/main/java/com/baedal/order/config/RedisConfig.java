package com.baedal.order.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.core.HashOperations;
import org.springframework.data.redis.core.RedisTemplate;

@Configuration
public class RedisConfig {

  @Bean
  public HashOperations<String, String, String> hashOperations(
      RedisTemplate<String, String> redisTemplate) {
    return redisTemplate.opsForHash();
  };

}
