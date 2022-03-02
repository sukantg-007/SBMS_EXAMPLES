package com.vc.ms;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@EnableDiscoveryClient
@RestController
public class Application {

	@GetMapping("/welcome")
	public String getMessage() {
		return "Welcome This is Eureka client 1";
	}
	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

}
