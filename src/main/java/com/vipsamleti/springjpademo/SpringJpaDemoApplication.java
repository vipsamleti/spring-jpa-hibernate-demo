package com.vipsamleti.springjpademo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@EnableJpaRepositories(basePackages = "com.vipsamleti.springjpademo.repository")
@SpringBootApplication
public class SpringJpaDemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringJpaDemoApplication.class, args);
	}

}
