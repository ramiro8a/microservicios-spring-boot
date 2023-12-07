package com.gateway.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.UUID;

@Configuration
public class ApiGatewayConfig {

    @Bean
    public RouteLocator customRouteLocator(RouteLocatorBuilder builder){
        return builder.routes()
                .route( r -> r
                        .path("/crea-cliente")
                        .filters(f -> f
                                .rewritePath("/crea-cliente", "/cliente")
                                .addRequestHeader("request_id", UUID.randomUUID().toString())
                        ).uri("http://localhost:8022")
                )
                .build();
    }
}
