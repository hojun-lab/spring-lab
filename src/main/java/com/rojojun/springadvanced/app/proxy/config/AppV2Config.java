package com.rojojun.springadvanced.app.proxy.config;

import com.rojojun.springadvanced.app.proxy.v1.*;
import com.rojojun.springadvanced.app.proxy.v2.ProxyOrderControllerV2;
import com.rojojun.springadvanced.app.proxy.v2.ProxyOrderRepositoryV2;
import com.rojojun.springadvanced.app.proxy.v2.ProxyOrderServiceV2;
import org.springframework.context.annotation.Bean;

public class AppV2Config {
    @Bean
    public ProxyOrderControllerV2 proxyOrderControllerV2() {
        return new ProxyOrderControllerV2(proxyOrderServiceV2());
    }

    @Bean
    public ProxyOrderServiceV2 proxyOrderServiceV2() {
        return new ProxyOrderServiceV2(proxyOrderRepositoryV2());
    }

    @Bean
    public ProxyOrderRepositoryV2 proxyOrderRepositoryV2() {
        return new ProxyOrderRepositoryV2();
    }
}
