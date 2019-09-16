package com.lypgod.springboot.demo.cache;

        import org.springframework.cache.annotation.Cacheable;
        import org.springframework.stereotype.Service;

/**
 * @author lypgod
 */
@Service
public class TestService {
    @Cacheable(value = "currentTimeCache", keyGenerator = "springCacheKeyGenerator")
    public long getTime() {
        return System.currentTimeMillis();
    }
}