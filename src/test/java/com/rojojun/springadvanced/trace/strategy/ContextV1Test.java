package com.rojojun.springadvanced.trace.strategy;

import com.rojojun.springadvanced.trace.strategy.code.strategy.ContextV1;
import com.rojojun.springadvanced.trace.strategy.code.strategy.Strategy;
import com.rojojun.springadvanced.trace.strategy.code.strategy.StrategyLogic1;
import com.rojojun.springadvanced.trace.strategy.code.strategy.StrategyLogic2;
import com.rojojun.springadvanced.trace.template.code.AbstractTemplate;
import com.rojojun.springadvanced.trace.template.code.SubClassLogic1;
import com.rojojun.springadvanced.trace.template.code.SubClassLogic2;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

import javax.naming.Context;

@Slf4j
public class ContextV1Test {

    @Test
    void strategyV0() {
        logic1();
        logic2();
    }

    private void logic1() {
        long startTime = System.currentTimeMillis();
        // 비즈니스 로직 실행
        log.info("비즈니스 로직 1 실행");
        // 비즈니스 로직 종료
        long endTime = System.currentTimeMillis();
        long result = endTime - startTime;

        log.info("resultTime={}", result);
    }

    private void logic2() {
        long startTime = System.currentTimeMillis();
        // 비즈니스 로직 실행
        log.info("비즈니스 로직 2 실행");
        // 비즈니스 로직 종료
        long endTime = System.currentTimeMillis();
        long result = endTime - startTime;

        log.info("resultTime={}", result);
    }

    /**
    * 잔랙 페탄 시영
     * */
    @Test
    void strategyV1() {
        StrategyLogic1 strategyLogic1 = new StrategyLogic1();
        ContextV1 contextV1 = new ContextV1(strategyLogic1);
        contextV1.execute();

        StrategyLogic2 strategyLogic2 = new StrategyLogic2();
        ContextV1 contextV2 = new ContextV1(strategyLogic2);
        contextV2.execute();
    }

    @Test
    void strategyV2() {
        Strategy inner1 = () -> log.info("비즈니스 로직 1");
        ContextV1 contextV1 = new ContextV1(inner1);
        contextV1.execute();

        Strategy inner2 = () -> log.info("비즈니스 로직 2");
        ContextV1 contextV2 = new ContextV1(inner2);
        contextV2.execute();
    }

    @Test
    void strategyV3() {
        ContextV1 contextV1 = new ContextV1(() -> log.info("비즈니스 로직 1"));
        contextV1.execute();

        ContextV1 contextV2 = new ContextV1(() -> log.info("비즈니스 로직 2"));
        contextV2.execute();
    }
}
