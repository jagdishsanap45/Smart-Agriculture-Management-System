package org.jagdish_prac.distribution_service;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
//import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableCaching
public class DistributionServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(DistributionServiceApplication.class, args);
	}

}
