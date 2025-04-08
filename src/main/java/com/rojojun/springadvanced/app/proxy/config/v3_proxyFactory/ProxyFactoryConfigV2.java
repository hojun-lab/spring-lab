package com.rojojun.springadvanced.app.proxy.config.v3_proxyFactory;

import com.rojojun.springadvanced.app.proxy.config.v3_proxyFactory.advice.LogTraceAdvice;
import com.rojojun.springadvanced.app.proxy.v1.*;
import com.rojojun.springadvanced.app.v2.OrderControllerV2;
import com.rojojun.springadvanced.app.v2.OrderRepositoryV2;
import com.rojojun.springadvanced.app.v2.OrderServiceV2;
import com.rojojun.springadvanced.trace.logtrace.LogTrace;
import lombok.extern.slf4j.Slf4j;
import org.springframework.aop.Advisor;
import org.springframework.aop.framework.ProxyFactory;
import org.springframework.aop.support.DefaultPointcutAdvisor;
import org.springframework.aop.support.NameMatchMethodPointcut;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Slf4j
@Configuration
public class ProxyFactoryConfigV2 {
    @Bean
    public OrderControllerV2 orderControllerV1(LogTrace logTrace) {
        OrderControllerV2 orderControllerV1 = new OrderControllerV2(orderServiceV1(logTrace));

        ProxyFactory factory = new ProxyFactory(orderControllerV1);
        factory.addAdvisor(getAdvisor(logTrace));
        OrderControllerV2 proxy = (OrderControllerV2) factory.getProxy();
        log.info("ProxyFactory proxy={}, targe={}", proxy.getClass(), orderControllerV1.getClass());
        return proxy;
    }

    @Bean
    public OrderServiceV2 orderServiceV1(LogTrace logTrace) {
        OrderServiceV2 orderServiceV1 = new OrderServiceV2(orderRepositoryV1(logTrace));

        ProxyFactory factory = new ProxyFactory(orderServiceV1);
        factory.addAdvisor(getAdvisor(logTrace));
        OrderServiceV2 proxy = (OrderServiceV2) factory.getProxy();
        log.info("ProxyFactory proxy={}, targe={}", proxy.getClass(), orderServiceV1.getClass());
        return proxy;
    }

    @Bean
    public OrderRepositoryV2 orderRepositoryV1(LogTrace logTrace) {
        OrderRepositoryV2 orderRepositoryV1 = new OrderRepositoryV2();

        ProxyFactory factory = new ProxyFactory(orderRepositoryV1);
        factory.addAdvisor(getAdvisor(logTrace));
        OrderRepositoryV2 proxy = (OrderRepositoryV2) factory.getProxy();
        log.info("ProxyFactory proxy={}, targe={}", proxy.getClass(), orderRepositoryV1.getClass());
        return proxy;
    }

    private Advisor getAdvisor(LogTrace logTrace) {
        // pointcuut
        NameMatchMethodPointcut pointcut = new NameMatchMethodPointcut();
        pointcut.setMappedNames("request*", "order*", "save*");

        LogTraceAdvice advice = new LogTraceAdvice(logTrace);
        return new DefaultPointcutAdvisor(pointcut, advice);
    }
}
