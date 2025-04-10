package com.rojojun.springadvanced.app.proxy.v3;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
public class ProxyOrderControllerV3 {
    private final ProxyOrderServiceV3 serviceV3;

    public ProxyOrderControllerV3(ProxyOrderServiceV3 serviceV3) {
        this.serviceV3 = serviceV3;
    }

    @GetMapping("/proxy/v3/request")
    public String request(String itemId) {
        serviceV3.orderItem(itemId);
        return "ok";
    }

    @GetMapping("/proxy/v3/no-log")
    public String noLog() {
        return "";
    }
}
