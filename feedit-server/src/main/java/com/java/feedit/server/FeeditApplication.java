package com.java.feedit.server;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@ComponentScan(basePackages = {"com.java.feedit.core", "com.java.feedit.server"})
@EntityScan(basePackages = {"com.java.feedit.core.domain"})
@EnableJpaRepositories(basePackages = "com.java.feedit.core.repository")
@EnableAutoConfiguration
public class FeeditApplication {

	public static void main(String...args) {
		SpringApplication.run(FeeditApplication.class, args);
	}
	
}
