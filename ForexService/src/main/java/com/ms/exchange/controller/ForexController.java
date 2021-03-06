package com.ms.exchange.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.ms.exchange.model.ExchangeValue;
import com.ms.exchange.repository.ExchangeValueRepo;

@RestController
public class ForexController {
	@Autowired
	private ExchangeValueRepo exchangeValueRepo;

	@Autowired
	private Environment environment;

	@GetMapping("/currency-exchange/from/{from}/to/{to}")
	public ExchangeValue retrieveExchangeValue(@PathVariable("from") String from, @PathVariable("to") String to) {
		ExchangeValue exchangeValue = exchangeValueRepo.findByFromAndTo(from, to);
		exchangeValue.setPort(Integer.parseInt(environment.getProperty("local.server.port")));
		return exchangeValue;
	}
}
