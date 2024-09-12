package com.xlb.util;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import java.util.concurrent.TimeUnit;

@Service
public class RedisService {
    @Autowired
    private RedisTemplate<String, Object> redisTemplate;

    public void set(String key, Object value) {
        redisTemplate.opsForValue().set(key, value);
    }

    /**
     * 设置key-value，并设置过期时间
     * @param key
     * @param value
     * @param expire
     * @param timeUnit
     */
    public void setEx(String key, Object value, long expire, TimeUnit timeUnit) {
        redisTemplate.opsForValue().set(key, value, expire, timeUnit);
    }

    /**
     * 分布式锁，设置key-value
     * @param key
     * @param value
     * @return
     */
    public boolean setNx(String key, Object value) {
        return redisTemplate.opsForValue().setIfAbsent(key, value);
    }

    /**
     * 分布式锁，设置key-value，并设置过期时间
     * @param key
     * @param value
     * @param expire
     * @param timeUnit
     * @return
     */
    public boolean setNxEx(String key, Object value, long expire, TimeUnit timeUnit) {
        return redisTemplate.opsForValue().setIfAbsent(key, value, expire, timeUnit);
    }

    public boolean exists(String key) {
        return redisTemplate.opsForValue().get(key) != null;
    }

    public Object get(String key) {
        return redisTemplate.opsForValue().get(key);
    }

    public void delete(String key) {
        redisTemplate.delete(key);
    }

    /**
     * 自增
     * @param key
     * @return
     */
    public Long increment(String key) {
        return redisTemplate.opsForValue().increment(key);
    }

    /**
     * 自减
     * @param key
     * @return
     */
    public Long decrement(String key) {
        return redisTemplate.opsForValue().decrement(key);
    }
}
