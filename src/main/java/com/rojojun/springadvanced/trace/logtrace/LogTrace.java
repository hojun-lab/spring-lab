package com.rojojun.springadvanced.trace.logtrace;

import com.rojojun.springadvanced.trace.TraceStatus;

public interface LogTrace {
    TraceStatus begin(String message);
    void end (TraceStatus traceStatus);
    void exception (TraceStatus traceStatus, Exception exception);
}
