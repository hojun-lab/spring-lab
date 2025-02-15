package com.rojojun.springadvanced.app.proxy.config.v1_proxy.interface_proxy;

import com.rojojun.springadvanced.app.proxy.v1.ProxyOrderServiceV1;
import com.rojojun.springadvanced.trace.TraceStatus;
import com.rojojun.springadvanced.trace.logtrace.LogTrace;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class OrderServiceInterfaceProxy implements ProxyOrderServiceV1 {
    private final ProxyOrderServiceV1 target;
    private final LogTrace logTrace;

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
