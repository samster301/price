package com.wipro.price;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;

@EnableCircuitBreaker
@SpringBootApplication
public class PriceApplication {

	public static void main(String[] args) {
		SpringApplication.run(PriceApplication.class, args);
	}

}
