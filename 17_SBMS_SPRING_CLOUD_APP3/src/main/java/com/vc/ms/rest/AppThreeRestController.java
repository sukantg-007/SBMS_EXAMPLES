package com.vc.ms.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j
public class AppThreeRestController {

	@Autowired
	private RestTemplate template;
	
	@GetMapping("/showC")
	public String showA() {
		log.info("Welcome to Service3");
		//WRITE LOGIC
		log.info("Back to service3");
		return "From C";
	}
}
