package com.rojojun.springadvanced.app.proxy.config.v1_proxy.interface_proxy;

import com.rojojun.springadvanced.app.proxy.v1.ProxyOrderControllerV1;
import com.rojojun.springadvanced.app.proxy.v1.ProxyOrderRepositoryV1;
import com.rojojun.springadvanced.trace.TraceStatus;
import com.rojojun.springadvanced.trace.logtrace.LogTrace;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class OrderRepositoryInterfaceProxy implements ProxyOrderRepositoryV1 {
    private final ProxyOrderRepositoryV1 target;
    private final LogTrace logTrace;

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
