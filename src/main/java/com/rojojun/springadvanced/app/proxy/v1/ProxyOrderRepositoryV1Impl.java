package com.rojojun.springadvanced.app.proxy.v1;

public class ProxyOrderRepositoryV1Impl implements ProxyOrderRepositoryV1 {
    @Override
    public void save(String itemId) {
        // 저장 로직
        if (itemId.equals("ex")) {
            throw new IllegalStateException("예외 발생!");
        }
        sleep(1000);
    }

    private void sleep(int millis) {
        try {
            Thread.sleep(millis);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
