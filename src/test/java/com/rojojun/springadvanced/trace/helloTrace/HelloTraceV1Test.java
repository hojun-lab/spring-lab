package com.rojojun.springadvanced.trace.helloTrace;

import com.rojojun.springadvanced.trace.TraceStatus;
import org.junit.jupiter.api.Test;

//@SpringBootTest
class HelloTraceV1Test {

    @Test
    void begin_end() {
        HelloTraceV1 trace = new HelloTraceV1();
        TraceStatus status = trace.begin("Hello World");
        trace.end(status);
    }

    @Test
    void begin_exception() {
        HelloTraceV1 trace = new HelloTraceV1();
        TraceStatus status = trace.begin("Hello World");
        trace.exception(status, new IllegalArgumentException("에러!"));
    }
}