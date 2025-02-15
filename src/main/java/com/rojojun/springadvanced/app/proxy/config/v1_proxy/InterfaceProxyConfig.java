package com.rojojun.springadvanced.app.proxy.config.v1_proxy;

import com.rojojun.springadvanced.app.proxy.config.v1_proxy.interface_proxy.OrderControllerInterfaceProxy;
import com.rojojun.springadvanced.app.proxy.config.v1_proxy.interface_proxy.OrderRepositoryInterfaceProxy;
import com.rojojun.springadvanced.app.proxy.config.v1_proxy.interface_proxy.OrderServiceInterfaceProxy;
import com.rojojun.springadvanced.app.proxy.v1.*;
import com.rojojun.springadvanced.trace.logtrace.LogTrace;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class InterfaceProxyConfig {

    @Bean
    public ProxyOrderControllerV1 proxyOrderController(LogTrace logTrace) {
        ProxyOrderControllerV1Impl controllerV1 = new ProxyOrderControllerV1Impl(proxyOrderService(logTrace));
        return new OrderControllerInterfaceProxy(controllerV1, logTrace);
    }

    @Bean
    public ProxyOrderServiceV1 proxyOrderService(LogTrace logTrace) {
        ProxyOrderServiceV1Impl serviceV1 = new ProxyOrderServiceV1Impl(proxyOrderRepository(logTrace));
        return new OrderServiceInterfaceProxy(serviceV1, logTrace);
    }

    @Bean
    public ProxyOrderRepositoryV1 proxyOrderRepository(LogTrace logTrace) {
        ProxyOrderRepositoryV1Impl repositoryV1 = new ProxyOrderRepositoryV1Impl();
        return new OrderRepositoryInterfaceProxy(repositoryV1, logTrace);
    }
}
