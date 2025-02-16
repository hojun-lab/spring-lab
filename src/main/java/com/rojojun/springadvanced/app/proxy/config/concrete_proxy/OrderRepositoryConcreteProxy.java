package com.rojojun.springadvanced.app.proxy.config.concrete_proxy;

import com.rojojun.springadvanced.app.proxy.v2.ProxyOrderRepositoryV2;
import com.rojojun.springadvanced.trace.TraceStatus;
import com.rojojun.springadvanced.trace.logtrace.LogTrace;

public class OrderRepositoryConcreteProxy extends ProxyOrderRepositoryV2 {
    private final ProxyOrderRepositoryV2 target;
    private final LogTrace logTrace;

    public OrderRepositoryConcreteProxy(ProxyOrderRepositoryV2 target, LogTrace logTrace) {
        this.target = target;
        this.logTrace = logTrace;
    }

    @Override
    public void save(String itemId) {
        TraceStatus status = null;
        try {
            status = logTrace.begin("OrderRepositoryInterfaceProxy.save()");
            // 타겟 호출
            target.save(itemId);
            logTrace.end(status);
        } catch (Exception e) {
            logTrace.exception(status, e);
            throw e;
        }
    }
}
