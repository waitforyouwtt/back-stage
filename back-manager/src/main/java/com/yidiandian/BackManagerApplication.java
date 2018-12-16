package com.yidiandian;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@EnableEurekaClient
@SpringBootApplication
public class BackManagerApplication {

	public static void main(String[] args) {
		SpringApplication.run(BackManagerApplication.class, args);
	}

}

