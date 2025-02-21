package com.rojojun.springadvanced.jdkdynamic.code;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class AImpl implements AInterface{

    @Override
    public String call() {
        log.info("call AImpl");
        return "null";
    }
}
