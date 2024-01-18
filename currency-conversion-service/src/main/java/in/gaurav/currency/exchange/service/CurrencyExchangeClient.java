package in.gaurav.currency.exchange.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import in.gaurav.bo.CurrencyConversion;

//@FeignClient(name = "currency-exchange", url = "127.0.0.1:8000")
@FeignClient(name = "currency-exchange")
public interface CurrencyExchangeClient {

	@GetMapping("/currency-exchange/from/{from}/to/{to}")
	ResponseEntity<CurrencyConversion> getExchangeValue(@PathVariable String from, @PathVariable String to);

}
