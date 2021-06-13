package com.pjhu.aopioc.ioc;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestCycle {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext ac = new ClassPathXmlApplicationContext("cycle.xml");
        A a = ac.getBean(A.class);
        System.out.println(a.getB());
        System.out.println(a.getName());

        B b = ac.getBean(B.class);
        System.out.println(b.getA());
    }
}
