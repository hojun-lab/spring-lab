package com.rojojun.springadvanced.app.proxy.v2;

public class ProxyOrderServiceV2 {
    private final ProxyOrderRepositoryV2 proxyOrderRepositoryV2;

    public ProxyOrderServiceV2(ProxyOrderRepositoryV2 proxyOrderRepositoryV2) {
        this.proxyOrderRepositoryV2 = proxyOrderRepositoryV2;
    }

    public void orderItem(String itemId) {
        proxyOrderRepositoryV2.save(itemId);
    }
}
