package com.myshop;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.web.servlet.MultipartAutoConfiguration;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;
import org.springframework.web.multipart.support.MultipartFilter;

@SpringBootApplication(scanBasePackages = "com.myshop")
@ComponentScan
@EnableAutoConfiguration(exclude = {MultipartAutoConfiguration.class})
public class MyshopDemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(MyshopDemoApplication.class, args);
	}


	
}