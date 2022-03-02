package com.vc.ms;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@EnableDiscoveryClient
@RestController
@RequestMapping("/greet")
public class Application {

	@GetMapping("/{name}")
	public String greet(@PathVariable("name") String name) {
		return "Good Morning "+name;
	}
	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

}
