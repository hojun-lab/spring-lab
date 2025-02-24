//package com.rojojun.springadvanced.app.proxy.config.v2_dynamicproxy;
//
//import com.rojojun.springadvanced.app.proxy.config.v2_dynamicproxy.handler.LogTraceBasicHandler;
//import com.rojojun.springadvanced.app.proxy.v1.*;
//import com.rojojun.springadvanced.trace.logtrace.LogTrace;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//
//import java.lang.reflect.Proxy;
//
//@Configuration
//public class DynamicProxyBasicConfig {
//
//    @Bean
//    public ProxyOrderControllerV1 proxyOrderControllerV1Dynamic(LogTrace logTrace) {
//        ProxyOrderControllerV1 proxyOrderControllerV1 = new ProxyOrderControllerV1Impl(proxyOrderServiceV1Dynamic(logTrace));
//
//        return (ProxyOrderControllerV1) Proxy.newProxyInstance(
//                ProxyOrderControllerV1.class.getClassLoader(),
//                new Class[] {ProxyOrderControllerV1.class},
//                new LogTraceBasicHandler(proxyOrderControllerV1, logTrace)
//        );
//    }
//
//    @Bean
//    public ProxyOrderServiceV1 proxyOrderServiceV1Dynamic(LogTrace logTrace) {
//        ProxyOrderServiceV1 proxyOrderServiceV1 = new ProxyOrderServiceV1Impl(proxyOrderRepositoryV1Dynamic(logTrace));
//
//        return (ProxyOrderServiceV1) Proxy.newProxyInstance(
//                ProxyOrderServiceV1.class.getClassLoader(),
//                new Class[]{ProxyOrderServiceV1.class},
//                new LogTraceBasicHandler(proxyOrderServiceV1, logTrace)
//        );
//    }
//
//    @Bean
//    public ProxyOrderRepositoryV1 proxyOrderRepositoryV1Dynamic(LogTrace logTrace) {
//        ProxyOrderRepositoryV1 orderRepositoryV1 = new ProxyOrderRepositoryV1Impl();
//
//        return (ProxyOrderRepositoryV1) Proxy.newProxyInstance(
//                ProxyOrderRepositoryV1.class.getClassLoader(),
//                new Class[] {ProxyOrderRepositoryV1.class},
//                new LogTraceBasicHandler(orderRepositoryV1, logTrace)
//        );
//    }
//}
