package com.finstone.rabbitmq;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication(scanBasePackages="com.finstone.rabbitmq")
public class EcsRabbitmqApplication {

	public static void main(String[] args) {
		SpringApplication.run(EcsRabbitmqApplication.class, args);
	}

}
