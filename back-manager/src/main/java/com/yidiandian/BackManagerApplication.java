package com.yidiandian;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.data.jpa.convert.threeten.Jsr310JpaConverters;

@EnableEurekaClient
@SpringBootApplication
public class BackManagerApplication {

	public static void main(String[] args) {
		SpringApplication.run(BackManagerApplication.class, args);
	}

}

