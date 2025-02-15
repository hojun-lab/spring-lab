package com.rojojun.springadvanced.app.proxy.v1;

import org.springframework.web.bind.annotation.*;

@RestController //스프링은 @Controller 또는 @RequestMapping 이 있어야 스프링 컨트롤러로 인식
@ResponseBody
public interface ProxyOrderControllerV1 {

    @GetMapping("/proxy/v1/request")
    String request(@RequestParam("itemId") String itemId);

    @GetMapping("/proxy/v1/no-log")
    String noLog();
}
