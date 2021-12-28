package com.example.hw8;

import org.example.Calculator;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.context.annotation.RequestScope;

@Configuration
public class Config {

    @Bean
    @RequestScope
    public Calculator calculator(){
        return new Calculator();
    }
}
