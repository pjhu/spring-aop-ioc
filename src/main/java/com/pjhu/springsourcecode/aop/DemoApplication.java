package com.pjhu.springsourcecode.aop;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class DemoApplication {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext();
        ac.register(DemoConfig.class);
        ac.refresh();
        DemoService demoService = ac.getBean(DemoService.class);
        demoService.demo();
    }
}
