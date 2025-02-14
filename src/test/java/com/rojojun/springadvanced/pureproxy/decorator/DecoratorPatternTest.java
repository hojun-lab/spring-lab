package com.rojojun.springadvanced.pureproxy.decorator;

import com.rojojun.springadvanced.pureproxy.decorator.code.Component;
import com.rojojun.springadvanced.pureproxy.decorator.code.DecoratorPatternClient;
import com.rojojun.springadvanced.pureproxy.decorator.code.MessageDecorator;
import com.rojojun.springadvanced.pureproxy.decorator.code.RealComponent;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

@Slf4j
public class DecoratorPatternTest {

    @Test
    void noDecorator() {
        Component realComponent = new RealComponent();
        DecoratorPatternClient client = new DecoratorPatternClient(realComponent);
        client.execute();
    }

    @Test
    void decorator1() {
        Component realComponent = new RealComponent();
        MessageDecorator decorator = new MessageDecorator(realComponent);
        DecoratorPatternClient client = new DecoratorPatternClient(decorator);
        client.execute();
    }
}
