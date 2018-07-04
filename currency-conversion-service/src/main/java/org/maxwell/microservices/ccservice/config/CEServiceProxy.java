package org.maxwell.microservices.ccservice.config;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "currency-exchange-service", url = "localhost:8000")
public interface CEServiceProxy {

	@GetMapping("/currency-exchange/from/{from}/to/{to}")
	 CCService retrieveExchangeValue(@PathVariable("from") String from, @PathVariable("to") String to);
}
