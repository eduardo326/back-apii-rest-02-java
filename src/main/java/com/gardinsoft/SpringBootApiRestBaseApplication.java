package com.gardinsoft;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;

@SpringBootApplication
public class SpringBootApiRestBaseApplication{

	public static void main(String[] args) {
		SpringApplication.run(SpringBootApiRestBaseApplication.class, args);
	}
	

}
