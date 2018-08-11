package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@EnableDiscoveryClient
@SpringBootApplication
public class GetAppDocInfoServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(GetAppDocInfoServiceApplication.class, args);
	}
}
