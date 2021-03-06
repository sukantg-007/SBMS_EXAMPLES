package com.vc.ms;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class Application {

	@GetMapping("/getdiagnosis")
	public String getDiagnosisService() {
		return "Diagnosis Service Called";
	}
	
	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

}
