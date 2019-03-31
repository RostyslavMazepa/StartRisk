package com.mysolutions.startrisk;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class StartRiskApplication {

	public static void main(String[] args) {
		SpringApplication.run(StartRiskApplication.class, args);
	}
}

// mvn clean install
// mvn --projects backend spring-boot:run