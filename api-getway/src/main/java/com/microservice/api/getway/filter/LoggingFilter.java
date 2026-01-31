package com.microservice.api.getway.filter;

import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

@Component
@Slf4j
public class LoggingFilter implements GlobalFilter {

    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
        ServerHttpRequest request = exchange.getRequest();
        log.info("Path of the request received -> {}", exchange.getRequest().getPath());

        log.info("request comming: "+request.getURI().toString());
        String country = request.getHeaders().getFirst("country");
        if (country.equalsIgnoreCase("india")||country.equalsIgnoreCase("us")){
            throw new RuntimeException("country not allowed");
        }

        return chain.filter(exchange);
    }
}
