package com.clients.app.config;

import com.clients.commons.logs.FeignRequestIntereceptor;
import feign.RequestInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Config {
    @Bean
    public RequestInterceptor customResquestInterceptor(){
        return new FeignRequestIntereceptor();
    }
}
