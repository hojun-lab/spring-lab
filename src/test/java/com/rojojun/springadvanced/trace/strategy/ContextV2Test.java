package com.rojojun.springadvanced.trace.strategy;

import com.rojojun.springadvanced.trace.strategy.code.strategy.*;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

@Slf4j
public class ContextV2Test {

    @Test
    void strategyV0() {
        ContextV2 contextV2 = new ContextV2();
        contextV2.execute(new StrategyLogic1());
    }

    @Test
    void strategyV1() {
        ContextV2 contextV2 = new ContextV2();
        contextV2.execute(() -> log.info("비즈니스 로직 (람다) 실행"));
    }
}
