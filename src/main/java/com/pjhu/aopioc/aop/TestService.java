package com.pjhu.aopioc.aop;

import org.springframework.stereotype.Service;

@Service
public class TestService {

    @TestAnnotation("this is value")
    public void test1() {
        System.out.println("this is TestService.test1()");
    }

    @TestAnnotation(value = "this is another value", description = "this is description")
    public void test2() {
        System.out.println("this is TestService.test2()");
    }
}
