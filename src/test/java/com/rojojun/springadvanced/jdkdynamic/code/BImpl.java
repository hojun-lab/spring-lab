package com.rojojun.springadvanced.jdkdynamic.code;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
public class BImpl implements BInterface{
    @Override
    public String call() {
        log.info("call BImpl");
        return "";
    }
}
