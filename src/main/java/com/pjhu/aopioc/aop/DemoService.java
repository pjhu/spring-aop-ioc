package com.pjhu.aopioc.aop;

import org.springframework.stereotype.Service;

@Service
public class DemoService {

    @DemoAnnotation
    public void demo() {
        System.out.println("this is DemoService.demo()");
    }
}
