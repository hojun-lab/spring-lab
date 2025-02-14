package com.rojojun.springadvanced.pureproxy.decorator.code;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class MessageDecorator extends Decorator{
    public MessageDecorator(Component component) {
        super(component);
    }

    @Override
    public String operation() {
        log.info("MessageDecorate 실행");

        String operation = super.operation();
        String decoResult = "*****" + operation + "*****";
        log.info("Before Decorator = {}, after Decorator = {}", operation, decoResult);

        return decoResult;
    }
}
