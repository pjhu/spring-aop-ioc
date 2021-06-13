package com.pjhu.aopioc;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages={"com.pjhu.aopioc"})
public class AopiocApplication {

    public static void main(String[] args) {
        
        SpringApplication.run(AopiocApplication.class, args);
	}
}
