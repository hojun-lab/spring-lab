package com.rojojun.springadvanced.app.proxy.v3;

import org.springframework.stereotype.Service;

@Service
public class ProxyOrderServiceV3 {
    private final ProxyOrderRepositoryV3 repository;

    public ProxyOrderServiceV3(ProxyOrderRepositoryV3 repository) {
        this.repository = repository;
    }

    public void orderItem(String itemId) {
        repository.save(itemId);
    }
}
