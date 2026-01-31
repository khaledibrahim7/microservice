package com.microservice.api.getway.config;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class GatewayConfig {

    @Bean
    public RouteLocator customRouteLocator(RouteLocatorBuilder builder) {
        return builder.routes().route(d -> d
                        .path("/doctor/**")
                        .uri("lb://doctor"))
                .route(p->p.path("/patient/**")
                        .uri("lb://patient"))
                .route(pa->pa.path("/payment/**")
                        .uri("lb://payment"))

                .build();
    }
}