package in.gaurav.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import in.gaurav.entity.CurrencyExchange;
import in.gaurav.repository.CurrencyExchangeRepository;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping("/currency-exchange")
public class CurrencyExchangeController {

	@Autowired
	private CurrencyExchangeRepository repository;

	@Autowired
	private Environment environment;

	@GetMapping("/from/{from}/to/{to}")
	public ResponseEntity<CurrencyExchange> getExchangeValue(@PathVariable String from, @PathVariable String to) {
		log.info("getExchangeValue called with {} to {}", from, to);
		CurrencyExchange currencyExchange = repository.findByFromAndTo(from.toUpperCase(), to.toUpperCase());
		currencyExchange.setEnvironment(environment.getProperty("spring.application.name").concat(":")
				.concat(environment.getProperty("local.server.port")));
		return ResponseEntity.ok(currencyExchange);
	}

}
