package com.rojojun.springadvanced;

import com.rojojun.springadvanced.app.proxy.config.v2_dynamicproxy.DynamicProxyFilterConfig;
import com.rojojun.springadvanced.trace.logtrace.LogTrace;
import com.rojojun.springadvanced.trace.logtrace.ThreadLocalLogTrace;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Import;

@Import(DynamicProxyFilterConfig.class)
@SpringBootApplication(scanBasePackages = "com.rojojun.springadvanced.app.proxy")
public class SpringAdvancedApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringAdvancedApplication.class, args);
    }

    @Bean
    public LogTrace logTrace() {
        return new ThreadLocalLogTrace();
    }
}
