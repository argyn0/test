package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@SpringBootApplication
@Configuration
public class DemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

	@Bean
	public FilterRegistrationBean<RequestLoggingFilter> loggingFilter() {
		FilterRegistrationBean<RequestLoggingFilter> registrationBean = new FilterRegistrationBean<>();

		registrationBean.setFilter(new RequestLoggingFilter());
		registrationBean.addUrlPatterns("/*"); // Применяем логгер ко всем URL

		return registrationBean;
	}
}
