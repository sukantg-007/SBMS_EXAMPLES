package com.vc.ms;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
@RequestMapping("/emailservice")
public class EmailRestApplication {

	@GetMapping("/send")
	public String sendEmail() {
		return "Email service called";
	}
	public static void main(String[] args) {
		SpringApplication.run(EmailRestApplication.class, args);
	}

}
