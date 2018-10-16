package com.evolvice.rest.webservices;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication(scanBasePackages = { "com.evolvice" })
@EnableAutoConfiguration
@EnableJpaAuditing
public class EvolviceWebServicesApplication {

	public static void main(String[] args) {
		SpringApplication.run(EvolviceWebServicesApplication.class, args);
	}
}
