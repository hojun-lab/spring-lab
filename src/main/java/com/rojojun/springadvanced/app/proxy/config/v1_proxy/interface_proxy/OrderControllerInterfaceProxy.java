package com.rojojun.springadvanced.app.proxy.config.v1_proxy.interface_proxy;

import com.rojojun.springadvanced.app.proxy.v1.ProxyOrderControllerV1;
import com.rojojun.springadvanced.trace.TraceStatus;
import com.rojojun.springadvanced.trace.logtrace.LogTrace;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class OrderControllerInterfaceProxy implements ProxyOrderControllerV1 {
    private final ProxyOrderControllerV1 target;
    private final LogTrace logTrace;

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
        return "";
    }
}
