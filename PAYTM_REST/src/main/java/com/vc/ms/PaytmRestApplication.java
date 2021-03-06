package com.vc.ms;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
@RequestMapping("/paymentservice")
public class PaytmRestApplication {

	public static void main(String[] args) {
		SpringApplication.run(PaytmRestApplication.class, args);
	}
	
	@GetMapping("/payment")
	public String sendEmail() {
		return "Payment processed";
	}

}
