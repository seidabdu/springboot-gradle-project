package com.acid.aig.traning.aigtraning;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
@EnableCircuitBreaker
//@ComponentScan(basePackages = {"com.acid.aig.traning.aigtraning"})
public class AigTraningApplication {

	public static void main(String[] args) {
		SpringApplication.run(AigTraningApplication.class, args);
	}

	@Bean
	public RestTemplate restTemplate() {
		return new RestTemplate();
	}

}
