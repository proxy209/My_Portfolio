package com.org.kr;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.ComponentScan;


@ComponentScan("com.org.kr.*")
@SpringBootApplication
public class SpringTest1Application extends SpringBootServletInitializer{

	public static void main(String[] args) {
		SpringApplication.run(SpringTest1Application.class, args);
	}		
	   
}

 