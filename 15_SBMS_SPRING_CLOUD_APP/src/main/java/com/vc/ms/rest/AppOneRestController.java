package com.vc.ms.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j
public class AppOneRestController {

	@Autowired
	private RestTemplate template;
	
	@GetMapping("/showA")
	public String showA() {
		log.info("Welcome to Service1");
		ResponseEntity<String> forEntity = template.getForEntity("http://localhost:8082/showB", String.class);
		log.info("Back to service1. Data is {}",forEntity.getBody());
		return "Done";
	}
}
