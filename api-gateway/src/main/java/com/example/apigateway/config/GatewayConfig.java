package com.example.apigateway.config;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class GatewayConfig {

    @Bean
    public RouteLocator customRouteLocator(RouteLocatorBuilder builder) {
        return builder.routes()
            .route("user_service", r -> r.path("/users/**")
                .uri("http://localhost:8081"))
            .route("auth_service", r -> r.path("/auth/**")
                .uri("http://localhost:8082"))
            .route("inventory_service", r -> r.path("/inventory/**")
                .uri("http://localhost:8083"))
            .route("product_service", r -> r.path("/products/**")
                .uri("http://localhost:8084"))
            .route("cart_service", r -> r.path("/cart/**")
                .uri("http://localhost:8085"))
            .route("order_service", r -> r.path("/orders/**")
                .uri("http://localhost:8086"))
            .route("notification_service", r -> r.path("/notifications/**")
                .uri("http://localhost:8087"))
            .route("analytics_service", r -> r.path("/analytics/**")
                .uri("http://localhost:8088"))
            .build();
    }
}