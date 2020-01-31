package com.acid.aig.traning.aigtraning.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.reactive.function.client.WebClient;

import com.acid.aig.traning.aigtraning.model.Greeting;

import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/home")
public class HomeController {
	private WebClient client = WebClient.create("http://localhost:8080");

	@RequestMapping(value = "/welcome", produces = MediaType.APPLICATION_JSON_VALUE)
	public Mono<Greeting> getResult() {
		Mono<Greeting> greetingMono = client.get().uri("/greeting").accept(MediaType.APPLICATION_JSON).retrieve()
				.bodyToMono(Greeting.class);
		greetingMono.subscribe(System.out::println);

		return greetingMono;
	}

	@RequestMapping("/")
	public ResponseEntity<String> home() {
		return new ResponseEntity<String>("Welcome AIT stpring boot traning", HttpStatus.OK);
	}

}
