package com.pjhu.springsourcecode;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages={"com.pjhu.springsourcecode"})
public class SpringSourceCodeApplication {

    public static void main(String[] args) {
        
        SpringApplication.run(SpringSourceCodeApplication.class, args);
	}
}
