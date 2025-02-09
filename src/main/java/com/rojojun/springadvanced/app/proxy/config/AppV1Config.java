package com.rojojun.springadvanced.app.proxy.config;

import com.rojojun.springadvanced.app.proxy.v1.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppV1Config {

    @Bean
    public OrderControllerV1 orderControllerV1() {
        return new OrderControllerV1Impl(orderServiceV1());
    }

    @Bean
    public OrderServiceV1 orderServiceV1() {
        return new OrderServiceV1Impl(orderServiceRepositoryV1());
    }

    @Bean
    public OrderRepositoryV1 orderServiceRepositoryV1() {
        return new OrderRepositoryV1Impl();
    }
}
