package com.example.DepedencyInjection;

import com.example.DepedencyInjection.service.Dev;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class DepedencyInjectionApplication {


	public static void main(String[] args) {

		ApplicationContext context = SpringApplication.run(DepedencyInjectionApplication.class, args);
		Dev dev = context.getBean(Dev.class);
		dev.call();
	}

}
