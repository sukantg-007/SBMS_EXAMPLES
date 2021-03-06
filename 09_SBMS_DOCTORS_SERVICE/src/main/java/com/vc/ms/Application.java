package com.vc.ms;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class Application {

	@GetMapping("/getdoctorsservice")
	public String getDoctorsService() {
		return "Doctors service called";
	}
	
	@GetMapping("/welcome/{name}")
	public String wish(@PathVariable String name) {
		return "Hi.."+name+" Welcome to doctos service";
	}
	
	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

}
