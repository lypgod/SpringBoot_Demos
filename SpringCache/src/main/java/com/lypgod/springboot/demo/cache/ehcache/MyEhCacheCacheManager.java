package com.lypgod.springboot.demo.cache.ehcache;

import net.sf.ehcache.Ehcache;
import org.springframework.cache.Cache;
import org.springframework.cache.ehcache.EhCacheCache;
import org.springframework.cache.ehcache.EhCacheCacheManager;
import org.springframework.stereotype.Component;

import java.util.Objects;

/**
 * @author lypgod
 */
@Component
public class MyEhCacheCacheManager extends EhCacheCacheManager {
    @Override
    protected Cache getMissingCache(String name) {
        Cache cache = super.getMissingCache(name);
        if (cache == null) {
            Ehcache ehcache = Objects.requireNonNull(super.getCacheManager()).addCacheIfAbsent(name);
            cache = new EhCacheCache(ehcache);
        }
        return cache;
    }
}