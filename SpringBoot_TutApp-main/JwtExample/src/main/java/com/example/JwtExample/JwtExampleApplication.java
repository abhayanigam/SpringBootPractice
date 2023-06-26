package com.example.JwtExample;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class })
public class JwtExampleApplication extends SpringBootServletInitializer {

	public static void main(String[] args) {
		SpringApplication.run(JwtExampleApplication.class, args);
	}

}
