package org.maxwell.microservices.ceservice.controller;

import org.maxwell.microservices.ceservice.config.ExchangeValue;
import org.maxwell.microservices.ceservice.respository.ExchangeValueRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j
public class CurrencyExchangeController {

	@Autowired
	Environment environment;

	@Autowired
	ExchangeValueRepository repository;

	@GetMapping("/currency-exchange/from/{from}/to/{to}")
	public ExchangeValue retrieveExchangeValue(@PathVariable String from, @PathVariable String to) {
		log.debug("from value {} to value {}", from, to);
		ExchangeValue exchangeValue = repository.findByFromAndTo(from.toUpperCase(), to.toUpperCase());
		log.debug("exchange value FROM is {}", exchangeValue);
		exchangeValue.setPort(Integer.parseInt(environment.getProperty("local.server.port")));
		return exchangeValue;
	}

}
