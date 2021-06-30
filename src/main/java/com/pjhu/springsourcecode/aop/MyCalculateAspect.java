package com.pjhu.springsourcecode.aop;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

@Slf4j
@Aspect
@Component
public class MyCalculateAspect {

    @Pointcut("execution(* com.pjhu.springsourcecode.aop.MyCalculateService.*(..))")
    public void parameterPointCut() {
    }

    @Around(value = "parameterPointCut()")
    public Object validateParameter(ProceedingJoinPoint pjp) {

        Object rst = null;

        try {
            log.info("customized around start");
            rst = pjp.proceed(pjp.getArgs());
            log.info("customized around end");
        } catch (Throwable throwable) {
            log.info("around exception");
            throwable.printStackTrace();
        } finally {
            log.info("around finally");
        }
        return rst;
    }

    @Before(value = "parameterPointCut()")
    public void before() {
        log.info("customized around before");
    }


    @After(value = "parameterPointCut()")
    public void after() {
        log.info("customized around after");
    }
}
