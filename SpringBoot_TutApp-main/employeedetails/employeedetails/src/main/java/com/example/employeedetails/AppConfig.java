package com.example.employeedetails;

import com.example.employeedetails.model.Employee;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.connection.lettuce.LettuceConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;

@Configuration
public class AppConfig {
    //Creating Connection with Redis
    @Bean
    public RedisConnectionFactory redisConnectionFactory() {
        return new LettuceConnectionFactory();
    }

    //in the first point, there are two known drivers to connect to Redis DB : Jedis, Lettuce.
    // We are using the Lettuce driver (Latest one)

    //Creating RedisTemplate for Entity 'Employee'
    @Bean
    public RedisTemplate<String, Employee> redisTemplate(){
        RedisTemplate<String, Employee> empTemplate = new RedisTemplate<>();
        empTemplate.setConnectionFactory(redisConnectionFactory());
        return empTemplate;
    }
}
