package com.pjhu.aopioc.aop;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@Configuration
@ComponentScan("com.pjhu.aopioc.aop")
@EnableAspectJAutoProxy
public class DemoConfig {
}
