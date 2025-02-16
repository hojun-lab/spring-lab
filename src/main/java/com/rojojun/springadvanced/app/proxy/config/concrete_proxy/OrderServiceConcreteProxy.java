package com.rojojun.springadvanced.app.proxy.config.concrete_proxy;

import com.rojojun.springadvanced.app.proxy.v2.ProxyOrderRepositoryV2;
import com.rojojun.springadvanced.app.proxy.v2.ProxyOrderServiceV2;
import com.rojojun.springadvanced.trace.TraceStatus;
import com.rojojun.springadvanced.trace.logtrace.LogTrace;

public class OrderServiceConcreteProxy extends ProxyOrderServiceV2 {
    private final ProxyOrderServiceV2 target;
    private final LogTrace logTrace;

    public OrderServiceConcreteProxy(ProxyOrderServiceV2 target, LogTrace logTrace) {
        super(null);
        this.target = target;
        this.logTrace = logTrace;
    }

    @Override
    public void orderItem(String itemId) {
        TraceStatus traceStatus = null;
        try {
            traceStatus = logTrace.begin("OrderServiceInterfaceProxy.orderItem()");
            target.orderItem(itemId);
            logTrace.end(traceStatus);
        } catch (Exception e) {
            logTrace.exception(traceStatus, e);
            throw e;
        }
    }
}
