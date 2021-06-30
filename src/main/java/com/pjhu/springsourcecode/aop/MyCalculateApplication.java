package com.pjhu.springsourcecode.aop;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class MyCalculateApplication {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext();
        ac.register(MyCalculateConfig.class);
        ac.refresh();
        MyCalculateService bean = ac.getBean(MyCalculateService.class);
        System.out.println(bean.add(1,1));
    }
}
