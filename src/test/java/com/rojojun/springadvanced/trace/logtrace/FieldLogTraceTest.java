package com.rojojun.springadvanced.trace.logtrace;

import com.rojojun.springadvanced.trace.TraceStatus;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FieldLogTraceTest {
    FieldLogTrace fieldLogTrace = new FieldLogTrace();

    @Test
    void begin_and_leve2() {
        TraceStatus status1 = fieldLogTrace.begin("hello1");
        TraceStatus status2 = fieldLogTrace.begin("hello2");
        fieldLogTrace.end(status2);
        fieldLogTrace.end(status1);
    }

    @Test
    void begin_exception_level2() {
        TraceStatus status1 = fieldLogTrace.begin("hello1");
        TraceStatus status2 = fieldLogTrace.begin("hello2");
        fieldLogTrace.exception(status2, new IllegalArgumentException("예외!"));
        fieldLogTrace.exception(status1, new IllegalArgumentException("예외!"));
    }
}