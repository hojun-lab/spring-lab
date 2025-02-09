package com.rojojun.springadvanced.app.proxy.v1;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

// Spring 에서 컨트롤러라고 인식하는 경우 1. @Controller 2.@RequestMapping
@RequestMapping()
@ResponseBody
public interface ProxyOrderControllerV1 {

    @GetMapping("/v1/request")
    String request(@RequestParam("itemId") String itemId);

    @GetMapping("/v9/no-log")
    String noLog();
}
