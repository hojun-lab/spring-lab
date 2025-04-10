//package com.rojojun.springadvanced.app.proxy.config.v1_proxy;
//
//import com.rojojun.springadvanced.app.proxy.config.concrete_proxy.OrderControllerConcreteProxy;
//import com.rojojun.springadvanced.app.proxy.config.concrete_proxy.OrderRepositoryConcreteProxy;
//import com.rojojun.springadvanced.app.proxy.config.concrete_proxy.OrderServiceConcreteProxy;
//import com.rojojun.springadvanced.app.proxy.v2.ProxyOrderControllerV2;
//import com.rojojun.springadvanced.app.proxy.v2.ProxyOrderRepositoryV2;
//import com.rojojun.springadvanced.app.proxy.v2.ProxyOrderServiceV2;
//import com.rojojun.springadvanced.trace.logtrace.LogTrace;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//
//@Configuration
//public class ConcreteProxyConfig {
//
//    @Bean
//    public ProxyOrderControllerV2 proxyOrderControllerV2(LogTrace logTrace) {
//        ProxyOrderControllerV2 proxyOrderControllerV2 = new ProxyOrderControllerV2(proxyOrderServiceV2(logTrace));
//        return new OrderControllerConcreteProxy(proxyOrderControllerV2, logTrace);
//    }
//
//    @Bean
//    public ProxyOrderServiceV2 proxyOrderServiceV2(LogTrace logTrace) {
//        ProxyOrderServiceV2 proxyOrderServiceV2 = new ProxyOrderServiceV2(proxyOrderRepositoryV2(logTrace));
//        return new OrderServiceConcreteProxy(proxyOrderServiceV2, logTrace);
//    }
//
//    @Bean
//    public ProxyOrderRepositoryV2 proxyOrderRepositoryV2(LogTrace logTrace) {
//        ProxyOrderRepositoryV2 proxyOrderRepository = new ProxyOrderRepositoryV2();
//        return new OrderRepositoryConcreteProxy(proxyOrderRepository, logTrace);
//    }
//}
