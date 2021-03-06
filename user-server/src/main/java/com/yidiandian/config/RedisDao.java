package com.yidiandian.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Repository;

import java.util.concurrent.TimeUnit;

/**
 * @Author: 一点点
 * @Date: 2018/12/7 11:35
 * @Version 1.0
 */
@Repository
public class RedisDao {
    @Autowired
    private StringRedisTemplate template;

    public void setKey(String key, String value) {
        ValueOperations<String, String > ops = template.opsForValue();
        ops.set(key,value,1, TimeUnit.MINUTES);
    }

    public String getValue(String key) {
        ValueOperations<String, String> ops = this.template.opsForValue();
        return ops.get(key);
    }

}
