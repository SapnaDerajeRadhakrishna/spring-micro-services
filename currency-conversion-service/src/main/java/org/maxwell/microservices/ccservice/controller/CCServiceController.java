package org.maxwell.microservices.ccservice.controller;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

import org.maxwell.microservices.ccservice.config.CCService;
import org.maxwell.microservices.ccservice.config.CEServiceProxy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class CCServiceController {
	
	private static final String CE_SERVICE_URI = "http://localhost:8000/currency-exchange/from/{from}/to/{to}";
	
	@Autowired
	private RestTemplate restTemplate ;

	@Autowired
	private CEServiceProxy ceProxy;
	
	@Autowired
	Environment environment;

	@GetMapping("/currency-converter/from/{from}/to/{to}/quantity/{quantity}")
	public CCService convertCurrency(@PathVariable String from, @PathVariable String to,
			@PathVariable BigDecimal quantity) {

		Map<String, String> uriVariables = new HashMap<>();
		uriVariables.put("from", from);
		uriVariables.put("to", to);

		ResponseEntity<CCService> responseEntity = restTemplate.getForEntity(CE_SERVICE_URI, CCService.class,
				uriVariables);

		CCService serviceBean = responseEntity.getBody();
		BigDecimal currencyRate = serviceBean.getConversionRate();

		CCService ccService = new CCService(serviceBean.getId(), from, to, currencyRate, quantity,
				quantity.multiply(currencyRate), serviceBean.getPort());
		return ccService;

	}
	
	@GetMapping("/currency-converter-feign/from/{from}/to/{to}/quantity/{quantity}")
	public CCService convertCurrencyFromFeign(@PathVariable String from, @PathVariable String to,
			@PathVariable BigDecimal quantity) {

		CCService serviceBean = ceProxy.retrieveExchangeValue(from, to);
		BigDecimal currencyRate = serviceBean.getConversionRate();

		CCService ccService = new CCService(serviceBean.getId(), from, to, currencyRate, quantity,
				quantity.multiply(currencyRate), serviceBean.getPort());
		return ccService;

	}

}
