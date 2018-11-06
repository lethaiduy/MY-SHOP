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

	@Bean
	public CommonsMultipartResolver commonsMultipartResolver() {
		final CommonsMultipartResolver commonsMultipartResolver = new CommonsMultipartResolver();
		commonsMultipartResolver.setMaxUploadSize(20971520);
		commonsMultipartResolver.setMaxInMemorySize(1048576);
		return commonsMultipartResolver;
	}
	@Bean
    public FilterRegistrationBean openEntityManagerFilterRegistrationBean() {
        // Set upload filter
        final MultipartFilter multipartFilter = new MultipartFilter();
        final FilterRegistrationBean filterRegistrationBean = new FilterRegistrationBean(multipartFilter);
        filterRegistrationBean.addInitParameter("multipartResolverBeanName", "commonsMultipartResolver");

        return filterRegistrationBean;
    }

}