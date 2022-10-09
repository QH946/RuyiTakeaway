package com.qh.ruyitakeaway.config;

import org.springframework.cache.annotation.CachingConfigurerSupport;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.StringRedisSerializer;


/**
 * redis配置
 *
 * @author qh
 * @date 2022/10/09 12:03:54
 */
@Configuration
public class RedisConfig extends CachingConfigurerSupport {

    /**
     * 配置 key 的序列化器，使用字符串序列化器
     *
     * @param connectionFactory 连接工厂
     * @return {@link RedisTemplate}<{@link Object},{@link Object}>
     */
    @Bean
    public RedisTemplate<Object,Object> redisTemplate(RedisConnectionFactory connectionFactory){
        RedisTemplate<Object,Object> redisTemplate = new RedisTemplate<>();
        //默认的Key序列化器为: JdkSerializationRedisSerializer
        redisTemplate.setKeySerializer(new StringRedisSerializer());
        redisTemplate.setConnectionFactory( connectionFactory) ;
        return redisTemplate;
    }
}