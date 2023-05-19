package com.example.spring_restfull_jpa_repo_tut;

import com.example.spring_restfull_jpa_repo_tut.dao.EmployeeRepo;
import com.example.spring_restfull_jpa_repo_tut.entity.Employee;
import org.apache.juli.logging.Log;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.Stack;

@SpringBootApplication
public class SpringRestfullJpaRepoTutApplication {

//	private static final Logger logger = LoggerFactory.getLogger(SpringRestfullJpaRepoTutApplication.class);
	Logger logger = LoggerFactory.getLogger(SpringRestfullJpaRepoTutApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(SpringRestfullJpaRepoTutApplication.class, args);
	}

	@Bean

	public CommandLineRunner setup(EmployeeRepo employeeRepo){
		return args -> {
			employeeRepo.save(new Employee("John", "Pal", true));
			employeeRepo.save(new Employee("Tiger", "Singh", true));
			logger.info("The sample data has been generated");
		};
	}
}
