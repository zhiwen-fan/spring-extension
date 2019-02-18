package com.bruce.springboot.extension.starter;

import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Created by bruce on 2019/1/30.
 */
@Configuration
@EnableConfigurationProperties(CacheConfig.class)
public class CacheAutoConfiguration {

    @Bean
    @ConditionalOnMissingBean
    @ConditionalOnProperty(name = "cache.enabled",havingValue = "enabled")
    public CacheService cacheService() {
        return new CacheService();
    }
}
