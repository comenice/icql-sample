package work.icql.springboot.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cache.caffeine.CaffeineCacheManager;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.AnnotationUtils;
import org.springframework.data.redis.cache.RedisCacheConfiguration;
import org.springframework.data.redis.cache.RedisCacheManager;
import org.springframework.data.redis.cache.RedisCacheWriter;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.serializer.Jackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.RedisSerializationContext;
import org.springframework.util.ReflectionUtils;

import java.time.Duration;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

/**
 * @author icql
 * @version 1.0
 * @date 2018/11/22 10:25
 * @Title CacheConfig
 * @Description CacheConfig
 */
@Configuration
@EnableCaching
public class CacheConfig {

    @Value("${spring.cache.redis-default-expire}")
    private Long redisDefaultExpire;

    @Bean
    public CacheManager redisCacheManager(ApplicationContext applicationContext, RedisConnectionFactory factory) {
        return new RedisCacheManager(
                RedisCacheWriter.nonLockingRedisCacheWriter(factory),
                //默认过期时间
                RedisCacheConfiguration.defaultCacheConfig()
                        .entryTtl(Duration.ofSeconds(redisDefaultExpire + new Random().nextInt(10))),
                //@Cacheable 自定义过期时间
                getRedisCacheConfigMap(applicationContext)
        );
    }


    /**
     * 自定义过期时间：@Cacheable，cacheNames={cacheName#过期时间}
     *
     * @param applicationContext
     * @return
     */
    private Map<String, RedisCacheConfiguration> getRedisCacheConfigMap(ApplicationContext applicationContext) {
        Map<String, RedisCacheConfiguration> redisCacheConfigurationMap = new HashMap<>();

        String[] beanNames = applicationContext.getBeanNamesForType(Object.class);
        for (String beanName : beanNames) {
            final Class clazz = applicationContext.getType(beanName);
            ReflectionUtils.doWithMethods(clazz, method -> {
                ReflectionUtils.makeAccessible(method);
                Cacheable cacheable = AnnotationUtils.findAnnotation(method, Cacheable.class);
                if (cacheable != null) {
                    RedisCacheConfiguration defaultCacheConfig = RedisCacheConfiguration.defaultCacheConfig();
                    String[] strings = cacheable.cacheNames();
                    for (String item : strings) {
                        if (item.contains("#")) {
                            String[] split = item.split("#");
                            redisCacheConfigurationMap.put(item,
                                    defaultCacheConfig
                                            .entryTtl(Duration.ofSeconds(Long.valueOf(split[1]) + new Random().nextInt(10))));
                        }
                    }
                }

            });
        }
        return redisCacheConfigurationMap;
    }

    /*-------------------------------------------------------------------------------------------------*/


}
