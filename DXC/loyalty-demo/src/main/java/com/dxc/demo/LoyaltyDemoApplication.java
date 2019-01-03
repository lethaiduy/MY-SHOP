package com.dxc.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication(scanBasePackages="com.dxc.demo")
@ComponentScan(basePackages="com.dxc.demo.repository")
@EnableAutoConfiguration
public class LoyaltyDemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(LoyaltyDemoApplication.class, args);
	}

}

