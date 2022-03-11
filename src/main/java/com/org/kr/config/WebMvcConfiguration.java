package com.org.kr.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.org.kr.interceptor.CommonInterceptor;
import com.org.kr.interceptor.LoginInterceptor;

@Configuration
public class WebMvcConfiguration implements WebMvcConfigurer{
	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		registry.addInterceptor(new CommonInterceptor())
		.excludePathPatterns("/css/**", "/fonts/**", "/images/**", "/js/**", "/scss/**");
	}
}
