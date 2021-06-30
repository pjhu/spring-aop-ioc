package com.pjhu.springsourcecode.aop;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@Configuration
@ComponentScan("com.pjhu.springsourcecode.aop")
@EnableAspectJAutoProxy
public class DemoConfig {
}
