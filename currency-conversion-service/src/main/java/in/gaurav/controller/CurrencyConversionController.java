package in.gaurav.controller;

import java.math.BigDecimal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import in.gaurav.bo.CurrencyConversion;
import in.gaurav.currency.exchange.service.CurrencyExchangeClient;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping("/currency-conversion")
public class CurrencyConversionController {

	@Autowired
	private RestTemplate restTemplate;

	@Autowired
	private CurrencyExchangeClient currencyExchangeClient;

	@GetMapping("/from/{from}/to/{to}/quantity/{quantity}")
	public ResponseEntity<CurrencyConversion> getConversionValue(@PathVariable String from, @PathVariable String to,
			@PathVariable BigDecimal quantity) {
		log.info("getConversionValue called with {} to {} for quantity {}", from, to, quantity);
		CurrencyConversion currencyConversion = restTemplate.getForObject(
				"http://127.0.0.1:8000/currency-exchange/from/{from}/to/{to}", CurrencyConversion.class,
				from.toUpperCase(), to.toUpperCase());
		currencyConversion.setQuantity(quantity);
		currencyConversion.setTotalCalculatedValue(quantity.multiply(currencyConversion.getConversionRate()));
		return ResponseEntity.ok(currencyConversion);
	}

	@GetMapping("/feign/from/{from}/to/{to}/quantity/{quantity}")
	public ResponseEntity<CurrencyConversion> getConversionValueByFeign(@PathVariable String from,
			@PathVariable String to, @PathVariable BigDecimal quantity) {
		log.info("getConversionValueByFeign called with {} to {} for quantity {}", from, to, quantity);
		CurrencyConversion currencyConversion = currencyExchangeClient
				.getExchangeValue(from.toUpperCase(), to.toUpperCase()).getBody();
		currencyConversion.setQuantity(quantity);
		currencyConversion.setTotalCalculatedValue(quantity.multiply(currencyConversion.getConversionRate()));
		return ResponseEntity.ok(currencyConversion);
	}

}
