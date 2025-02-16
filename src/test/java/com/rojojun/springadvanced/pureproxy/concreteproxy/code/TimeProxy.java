package com.rojojun.springadvanced.pureproxy.concreteproxy.code;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class TimeProxy extends ConcreteLogic {
    private ConcreteLogic concreteLogic;

    public TimeProxy(ConcreteLogic concreteLogic) {
        this.concreteLogic = concreteLogic;
    }

    @Override
    public String operation() {
        log.info("Time Proxy 실행");
        log.info("TimeDecorator operation");
        long startTime = System.currentTimeMillis();
        String result = super.operation();
        long endTime = System.currentTimeMillis();

        log.info("TimeDecorator operation took {} ms", endTime - startTime);

        return result;
    }
}
