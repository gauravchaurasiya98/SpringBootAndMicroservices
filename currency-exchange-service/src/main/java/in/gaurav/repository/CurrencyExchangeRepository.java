package in.gaurav.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import in.gaurav.entity.CurrencyExchange;

public interface CurrencyExchangeRepository extends JpaRepository<CurrencyExchange, Integer> {
	CurrencyExchange findByFromAndTo(String from, String to);
}
