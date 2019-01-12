package com.yidiandian;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.ImportResource;
import org.springframework.data.jpa.convert.threeten.Jsr310JpaConverters;

@ImportResource(locations = {"classpath:quartz.xml"})
@EnableEurekaClient
@SpringBootApplication
@EntityScan(basePackages = {"com.yidiandian.entity"}, basePackageClasses = Jsr310JpaConverters.class)
public class UserServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(UserServerApplication.class, args);
	}
}
