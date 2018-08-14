package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@EnableCircuitBreaker
@EnableDiscoveryClient
@EnableJpaRepositories(basePackages = "com/example/demo/repository")
@SpringBootApplication
public class CreateOrUpdateAppDocInfoServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(CreateOrUpdateAppDocInfoServiceApplication.class, args);
	}
}
