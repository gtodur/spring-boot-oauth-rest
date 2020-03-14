package com.df.springboot.oauth.rest;

import java.util.concurrent.atomic.AtomicLong;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GreetingController {
	private static final String greetingTemplate = "Hello, %s!";
	private static final String sayByeTemplate = "Goodbye, %s!";
	private static final String saySomethingElseTemplate = "How are you, %s!";
	private final AtomicLong counter = new AtomicLong();
	
	@GetMapping(value = "/greeting")
	public Greeting greeting(@RequestParam(value = "name", defaultValue = "World") String name) {
		return new Greeting(counter.incrementAndGet(), String.format(greetingTemplate, name));
		//return new ResponseEntity<Greeting>(new Greeting(counter.incrementAndGet(), String.format(greetingTemplate, name)), HttpStatus.UNAUTHORIZED);
	}
	
	@GetMapping(value = "/sayBye")
	public Greeting sayBye(@RequestParam(value = "name", defaultValue = "World") String name) {
		return new Greeting(counter.incrementAndGet(), String.format(sayByeTemplate, name));
	}
	
	@GetMapping(value = "/saySomethingElse")
	public Greeting saySomethingElse(@RequestParam(value = "name", defaultValue = "World") String name) {
		return new Greeting(counter.incrementAndGet(), String.format(saySomethingElseTemplate, name));
	}
	
}
