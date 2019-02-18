package com.bruce.springboot.extension.starter;

import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by bruce on 2019/1/30.
 */
public class CacheService {

    @Autowired
    private CacheConfig cacheConfig;

    public String toString() {
        return cacheConfig.toString();
    }
}
