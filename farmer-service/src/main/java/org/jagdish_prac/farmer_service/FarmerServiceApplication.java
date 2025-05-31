package org.jagdish_prac.farmer_service;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
//import org.springframework.cloud.netflix.eureka.EnableEurekaClient;


@SpringBootApplication
public class FarmerServiceApplication {

	public static void main(String[] args) {

		SpringApplication.run(FarmerServiceApplication.class, args);


	}
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application){
		return application.sources(FarmerServiceApplication.class);
	}

//	@Override
//	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
//		return application.sources(FarmerServiceApplication.class);
//	}

}
