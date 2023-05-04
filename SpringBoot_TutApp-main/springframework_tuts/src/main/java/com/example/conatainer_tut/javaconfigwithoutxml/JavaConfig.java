package com.example.conatainer_tut.javaconfigwithoutxml;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
//@ComponentScan(basePackages = "com.example.conatainer_tut.javaconfigwithoutxml") --> If we are using @Bean then don't need to use this annotations
public class JavaConfig {
    @Bean
    public Example getExample(){
        Example example = new Example();
        return example;
    }
}
