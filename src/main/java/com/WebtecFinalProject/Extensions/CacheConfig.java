package com.WebtecFinalProject.Extensions;

import org.springframework.cache.CacheManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.cache.concurrent.ConcurrentMapCacheManager;


@Configuration
public class CacheConfig {
    @Bean
    public CacheManager cacheManager() {
        return new ConcurrentMapCacheManager("allSoldiersCache");
    }
}
