package com.rojojun.springadvanced.jdkdynamic;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

@Slf4j
public class ReflectionTest {

    @Test
    void reflection0() {
        Hello hello = new Hello();

        // 공통 로직 1 시작
        log.info("start");
        String result1 = hello.callA();
        log.info("result1={}", result1);
        // 공통 로직 1 종료

        // 공통 로직 2 시작
        log.info("start");
        String result2 = hello.callB();
        log.info("result1={}", result2);
        // 공통 로직 2 종료
    }

    @Test
    void reflection1() throws ClassNotFoundException, NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        // 클래스 정보 획득
        Class classHello = Class.forName("com.rojojun.springadvanced.jdkdynamic.ReflectionTest$Hello");
        Hello target = new Hello();
        // callA 메서드 정보
        Method methodCallA = classHello.getMethod("callA");
        Object result1 = methodCallA.invoke(target);

        log.info("results1`={}", result1);

        Method methodCallB = classHello.getMethod("callB");
        Object result2 = methodCallB.invoke(target);
        log.info("results2`={}", result2);
    }

    @Test
    void reflection2() throws ClassNotFoundException, NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        // 클래스 정보 획득
        Class classHello = Class.forName("com.rojojun.springadvanced.jdkdynamic.ReflectionTest$Hello");
        Hello target = new Hello();
        // callA 메서드 정보
        Method methodCallA = classHello.getMethod("callA");
        dynamicCall(methodCallA, target);

        Method methodCallB = classHello.getMethod("callB");
        dynamicCall(methodCallB, target);
    }

    private void dynamicCall(Method method, Object target) throws InvocationTargetException, IllegalAccessException {
        log.info("start");
        Object result = method.invoke(target);
        log.info("result={}", result);
    }

    @Slf4j
    static class Hello {
        public String callA() {
            log.info("callA");
            return "A";
        }

        public String callB() {
            log.info("callB");
            return "B";
        }
    }
}
