package com.ms.currencyconv;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class CurrencyConversionController {

	@GetMapping("/currency-convertor/from/{from}/to/{to}/quantity/{quantity}")
	public CorrencyConversionBean currenctCurrency(@PathVariable String from, @PathVariable String to, @PathVariable BigDecimal quantity) {
		Map<String, String> variable=new HashMap<>();
		variable.put("from", from);
		variable.put("to", to);
		
		ResponseEntity<CorrencyConversionBean> responseEntity=new RestTemplate().getForEntity("http://localhost:2020/currency-exchange/from/{from}/to/{to}", CorrencyConversionBean.class,variable);
		CorrencyConversionBean response=responseEntity.getBody();
		return new CorrencyConversionBean(response.getId(),from,to,response.getConversionMultiple(),quantity,quantity.multiply(response.getConversionMultiple()),response.getPort());
	}
}
