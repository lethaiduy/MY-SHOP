package com.myshop;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication(scanBasePackages="com.myshop")
@ComponentScan
@EnableAutoConfiguration
public class MyshopDemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(MyshopDemoApplication.class, args);
	}
}
