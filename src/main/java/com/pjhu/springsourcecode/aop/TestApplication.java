package com.pjhu.springsourcecode.aop;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class TestApplication {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext();
        ac.register(MyCalculateConfig.class);
        ac.refresh();
        TestService testService = ac.getBean(TestService.class);

        testService.test1();
        System.out.println("----------------------------");
        testService.test2();
    }
}
