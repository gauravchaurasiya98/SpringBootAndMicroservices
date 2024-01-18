package in.gaurav.entity;

import java.math.BigDecimal;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Transient;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class CurrencyExchange {
	@Id
	// @GeneratedValue(generator = "currencyExchangeIdGenerator")
	// @SequenceGenerator(name = "currencyExchangeIdGenerator", sequenceName = "currency_exchange_id_seq", initialValue = 1001, allocationSize = 10)
	private Integer id;
	@Column(name = "currency_from")
	private String from;
	@Column(name = "currency_to")
	private String to;
	private BigDecimal conversionRate;
	@Transient
	private String environment;
}
