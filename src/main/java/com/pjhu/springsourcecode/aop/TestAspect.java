package com.pjhu.springsourcecode.aop;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class TestAspect {

    @Pointcut("@annotation(com.pjhu.springsourcecode.aop.TestAnnotation)")
    public void test() {}

    @Before("test() && @annotation(testAnnotation)")
    public void action(TestAnnotation testAnnotation) {
        System.out.println("Annotation value : " + testAnnotation.value());
        System.out.println("Annotation description : " + testAnnotation.description());
        System.out.println("this is TestAspect.action()");
    }
}
