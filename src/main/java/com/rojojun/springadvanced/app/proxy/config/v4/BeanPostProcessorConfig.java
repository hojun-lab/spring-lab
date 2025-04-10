package com.rojojun.springadvanced.app.proxy.config.v4;

import com.rojojun.springadvanced.app.proxy.config.AppV1Config;
import com.rojojun.springadvanced.app.proxy.config.v3_proxyFactory.advice.LogTraceAdvice;
import com.rojojun.springadvanced.app.proxy.config.v4.postprocessor.PackageLogTracePostProcessor;
import com.rojojun.springadvanced.trace.logtrace.LogTrace;
import lombok.extern.slf4j.Slf4j;
import org.springframework.aop.Advisor;
import org.springframework.aop.support.DefaultPointcutAdvisor;
import org.springframework.aop.support.NameMatchMethodPointcut;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Slf4j
@Configuration
@Import({AppV1Config.class, AppV1Config.class})
public class BeanPostProcessorConfig {
    @Bean
    public PackageLogTracePostProcessor logTracePostProcessor(LogTrace logTrace) {
        return new PackageLogTracePostProcessor("com.rojojun.springadvanced.app", getAdvisor(logTrace));

    }

    private Advisor getAdvisor(LogTrace logTrace) {
        NameMatchMethodPointcut pointcut = new NameMatchMethodPointcut();
        pointcut.setMappedNames("request*", "order*", "save*");

        LogTraceAdvice advice = new LogTraceAdvice(logTrace);
        return new DefaultPointcutAdvisor(pointcut, advice);
    }
}
