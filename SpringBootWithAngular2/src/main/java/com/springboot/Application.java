package com.springboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
public class Application {

//	@Bean
//	public FilterRegistrationBean jwtFilter() {
//		final FilterRegistrationBean registrationBean = new FilterRegistrationBean();
//		registrationBean.setFilter(new JwtFilter());
//		registrationBean.addUrlPatterns("/rest/*");
//		return registrationBean;
//	}

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}
}
