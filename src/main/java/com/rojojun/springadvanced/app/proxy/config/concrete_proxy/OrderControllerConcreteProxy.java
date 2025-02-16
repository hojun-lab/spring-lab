package com.rojojun.springadvanced.app.proxy.config.concrete_proxy;

import com.rojojun.springadvanced.app.proxy.v2.ProxyOrderControllerV2;
import com.rojojun.springadvanced.app.proxy.v2.ProxyOrderServiceV2;
import com.rojojun.springadvanced.trace.TraceStatus;
import com.rojojun.springadvanced.trace.logtrace.LogTrace;

public class OrderControllerConcreteProxy extends ProxyOrderControllerV2 {
    private final ProxyOrderControllerV2 target;
    private final LogTrace logTrace;

    public OrderControllerConcreteProxy(ProxyOrderControllerV2 target, LogTrace logTrace) {
        super(null);
        this.target = target;
        this.logTrace = logTrace;
    }

    @Override
    public String request(String itemId) {
        TraceStatus status = null;
        try {
            status = logTrace.begin("OrderControllerInterfaceProxy::request");
            String result = target.request(itemId);
            logTrace.end(status);
            return result;
        } catch (Exception e) {
            logTrace.exception(status, e);
            throw e;
        }
    }

    @Override
    public String noLog() {
        return target.noLog();
    }
}
