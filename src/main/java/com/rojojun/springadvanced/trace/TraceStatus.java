package com.rojojun.springadvanced.trace;

import lombok.Getter;

public record TraceStatus(
        TraceId traceId,
        Long startTime,
        String message
) {

}
