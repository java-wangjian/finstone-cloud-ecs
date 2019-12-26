package com.wangshi.rabbitmq;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages="com.wangshi.rabbitmq")
public class EcsRabbitmqApplication {

	public static void main(String[] args) {
		SpringApplication.run(EcsRabbitmqApplication.class, args);
	}

}
