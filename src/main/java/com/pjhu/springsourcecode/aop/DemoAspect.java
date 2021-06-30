package com.pjhu.springsourcecode.aop;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class DemoAspect {

    @Before("@annotation(com.pjhu.springsourcecode.aop.DemoAnnotation)")
    public void demoBefore() {
        System.out.println("this is before output message");
    }
}
