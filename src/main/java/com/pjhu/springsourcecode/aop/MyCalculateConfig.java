package com.pjhu.springsourcecode.aop;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@EnableAspectJAutoProxy
@Configuration
@ComponentScan("com.pjhu.springsourcecode.aop")
public class MyCalculateConfig {
}
