package com.vc.ms.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j
public class AppTwoRestController {

	@Autowired
	private RestTemplate template;
	
	@GetMapping("/showB")
	public String showA() {
		log.info("Welcome to Service2");
		ResponseEntity<String> forEntity = template.getForEntity("http://localhost:8083/showC", String.class);
		log.info("Back to service2. Data is {}",forEntity.getBody());
		return "From showB ->"+forEntity.getBody();
	}
}
