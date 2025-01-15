package com.rojojun.springadvanced.trace.helloTrace;

import com.rojojun.springadvanced.trace.TraceStatus;
import org.junit.jupiter.api.Test;

//@SpringBootTest
class HelloTraceV2Test {

    @Test
    void begin_end() {
        HelloTraceV2 trace = new HelloTraceV2();
        TraceStatus status1 = trace.begin("Hello World");
        TraceStatus status2 = trace.beginSync(status1.traceId(), "hello2");
        trace.end(status2);
        trace.end(status1);
    }

    @Test
    void begin_exception() {
        HelloTraceV2 trace = new HelloTraceV2();
        TraceStatus status1 = trace.begin("Hello World");
        TraceStatus status2 = trace.beginSync(status1.traceId(), "hello2");
        trace.exception(status2, new IllegalStateException("boom"));
        trace.exception(status1, new IllegalArgumentException("에러!"));
    }
}