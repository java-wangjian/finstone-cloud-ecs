package com.finstone.oauthcenter;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;

@SpringBootApplication
@EnableResourceServer
@EnableEurekaClient
public class OauthcenterApplication {

	public static void main(String[] args) {
		SpringApplication.run(OauthcenterApplication.class, args);
	}

}
