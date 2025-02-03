package com.rojojun.springadvanced.app.v5;

import com.rojojun.springadvanced.trace.callback.TraceTemplate;
import com.rojojun.springadvanced.trace.logtrace.LogTrace;
import com.rojojun.springadvanced.trace.template.AbstractTemplate;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class OrderControllerV5 {
    private final OrderServiceV5 orderService;
    private final TraceTemplate traceTemplate;

    public OrderControllerV5(OrderServiceV5 orderService, LogTrace logTrace) {
        this.orderService = orderService;
        this.traceTemplate = new TraceTemplate(logTrace);
    }

    @GetMapping("/v5/request")
    public String request(String itemId) {
        return traceTemplate.excute("OrderController.request()", () ->{
            orderService.orderItem(itemId);
            return "ok";
        });

//        AbstractTemplate<String> template = new AbstractTemplate<String>(trace) {
//            @Override
//            protected String call() {
//                orderService.orderItem(itemId);
//                return "ok";
//            }
//        };
//        return template.execute("OrderController.request()");
    }
}
