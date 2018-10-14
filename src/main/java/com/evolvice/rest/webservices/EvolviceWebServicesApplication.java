package com.evolvice.rest.webservices;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication(scanBasePackages = { "com.evolvice" })
@ComponentScan({ "com.evolvice.rest.webservices", "com.evolvice.rest.webservices.models",
		"com.evolvice.rest.webservices.evolvicewebservices", "com.evolvice.rest.webservices.daos",
		"com.evolvice.rest.webservices.exceptions" }) // If our Controller class or Service class is not in the same
// packages we have //to add packages's name like
// this...directory(package) with main class
@EnableAutoConfiguration
@EnableJpaAuditing
public class EvolviceWebServicesApplication {

	public static void main(String[] args) {
		SpringApplication.run(EvolviceWebServicesApplication.class, args);
	}
}
