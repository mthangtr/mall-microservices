package com.example.apigateway.filters;

import org.springframework.cloud.gateway.filter.GatewayFilter;
import org.springframework.cloud.gateway.filter.factory.AbstractGatewayFilterFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

@Component
public class AuthFilter extends AbstractGatewayFilterFactory<AuthFilter.Config> {

    public AuthFilter() {
        super(Config.class);
    }

    @Override
    public GatewayFilter apply(Config config) {
        return (exchange, chain) -> {
            String authHeader = exchange.getRequest().getHeaders().getFirst("Authorization");
            if (authHeader == null || !authHeader.startsWith("Bearer ")) {
                return Mono.error(new RuntimeException("Authorization header is missing or invalid"));
            }

            // Here you would typically validate the JWT token
            // For example, by calling an authentication service or using a JWT library

            return chain.filter(exchange);
        };
    }

    @Override
    public String name() {
        return "AuthFilter";
    }

    public static class Config {
        // Configuration properties can be added here if needed
    }
}