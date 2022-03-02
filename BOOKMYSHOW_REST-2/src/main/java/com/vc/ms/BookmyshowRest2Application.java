package com.vc.ms;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

@SpringBootApplication
@EnableHystrix
@EnableHystrixDashboard
@RestController
public class BookmyshowRest2Application {

	@Autowired
	private RestTemplate template;

	@HystrixCommand(groupKey = "Hystrix Example", commandKey = "Hystrix Hit-Count", fallbackMethod = "bookMyshowFallback")
	@GetMapping("/booknow")
	public String bookMyShow() {
		String emailServiceReponse = template.getForObject("http://localhost:8181/emailservice/send", String.class);
		String paymentServiceReponse = template.getForObject("http://localhost:8282/paymentservice/payment",
				String.class);
		return emailServiceReponse + "\n" + paymentServiceReponse;
	}

	public static void main(String[] args) {
		SpringApplication.run(BookmyshowRest2Application.class, args);
	}
	
	@GetMapping("/booknowwithouthystrix")
	public String bookMyshowWithoudHystrix() {
		String emailServiceReponse = template.getForObject("http://localhost:8181/emailservice/send", String.class);
		String paymentServiceReponse = template.getForObject("http://localhost:8283/paymentservice/payment",
				String.class);
		return emailServiceReponse + "\n" + paymentServiceReponse;
	}

	@Bean
	public RestTemplate restTemplate() {
		return new RestTemplate();
	}
	
	public String bookMyshowFallback() {
		return "service gateway failed";
	}

}
