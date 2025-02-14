package com.rojojun.springadvanced.pureproxy.decorator.code;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class RealComponent implements Component {
    @Override
    public String operation() {
        log.info("operation 실행");
        return "data";
    }
}
