//package com.rojojun.springadvanced.app.proxy.config.v3_proxyFactory;
//
//import com.rojojun.springadvanced.app.proxy.config.v3_proxyFactory.advice.LogTraceAdvice;
//import com.rojojun.springadvanced.app.proxy.v1.*;
//import com.rojojun.springadvanced.app.v1.OrderControllerV1;
//import com.rojojun.springadvanced.app.v1.OrderRepositoryV1;
//import com.rojojun.springadvanced.trace.logtrace.LogTrace;
//import lombok.extern.java.Log;
//import lombok.extern.slf4j.Slf4j;
//import org.springframework.aop.Advisor;
//import org.springframework.aop.framework.ProxyFactory;
//import org.springframework.aop.support.DefaultPointcutAdvisor;
//import org.springframework.aop.support.NameMatchMethodPointcut;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//
//@Slf4j
//@Configuration
//public class ProxyFactoryConfigV1 {
//
//    @Bean
//    public ProxyOrderControllerV1 orderControllerV1(LogTrace logTrace) {
//        ProxyOrderControllerV1 orderControllerV1 = new ProxyOrderControllerV1Impl(orderServiceV1(logTrace));
//
//        ProxyFactory factory = new ProxyFactory(orderControllerV1);
//        factory.addAdvisor(getAdvisor(logTrace));
//        ProxyOrderControllerV1 proxy = (ProxyOrderControllerV1) factory.getProxy();
//        log.info("ProxyFactory proxy={}, targe={}", proxy.getClass(), orderControllerV1.getClass());
//        return proxy;
//    }
//
//    @Bean
//    public ProxyOrderServiceV1 orderServiceV1(LogTrace logTrace) {
//        ProxyOrderServiceV1Impl orderServiceV1 = new ProxyOrderServiceV1Impl(orderRepositoryV1(logTrace));
//
//        ProxyFactory factory = new ProxyFactory(orderServiceV1);
//        factory.addAdvisor(getAdvisor(logTrace));
//        ProxyOrderServiceV1 proxy = (ProxyOrderServiceV1) factory.getProxy();
//        log.info("ProxyFactory proxy={}, targe={}", proxy.getClass(), orderServiceV1.getClass());
//        return proxy;
//    }
//
//    @Bean
//    public ProxyOrderRepositoryV1 orderRepositoryV1(LogTrace logTrace) {
//        ProxyOrderRepositoryV1Impl orderRepositoryV1 = new ProxyOrderRepositoryV1Impl();
//
//        ProxyFactory factory = new ProxyFactory(orderRepositoryV1);
//        factory.addAdvisor(getAdvisor(logTrace));
//        ProxyOrderRepositoryV1 proxy = (ProxyOrderRepositoryV1) factory.getProxy();
//        log.info("ProxyFactory proxy={}, targe={}", proxy.getClass(), orderRepositoryV1.getClass());
//        return proxy;
//    }
//
//    private Advisor getAdvisor(LogTrace logTrace) {
//        // pointcuut
//        NameMatchMethodPointcut pointcut = new NameMatchMethodPointcut();
//        pointcut.setMappedNames("request*", "order*", "save*");
//
//        LogTraceAdvice advice = new LogTraceAdvice(logTrace);
//        return new DefaultPointcutAdvisor(pointcut, advice);
//    }
//}
