package com.example.product;

import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.core.env.Environment;

@SpringBootApplication
public class ProductApplication {

	@Autowired
	private Environment environment;

	public static void main(String[] args) {
		SpringApplication.run(ProductApplication.class, args);
	}

	@PostConstruct
	public void printPort() {
		String port = environment.getProperty("local.server.port");
		System.out.println("Application is running on port: " + port);
	}
}
