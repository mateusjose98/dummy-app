package com.mateusjose98.dummyapp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

@Service
public class CacheService<T> {

    @Autowired
    private RedisTemplate<String, T> redisTemplate;

    public void save(String key, T value) {
        redisTemplate.opsForValue().set(key, value);
    }

    public T get(String key) {
        return redisTemplate.opsForValue().get(key);
    }

    public void delete(String key) {
        redisTemplate.delete(key);
    }
}
