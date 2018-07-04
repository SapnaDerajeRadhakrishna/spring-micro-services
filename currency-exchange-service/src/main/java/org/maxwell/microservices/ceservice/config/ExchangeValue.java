package org.maxwell.microservices.ceservice.config;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@Entity
public class ExchangeValue {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@Column(name = "currency_from")
	private String from;

	@Column(name = "currency_to")
	private String to;

	private BigDecimal conversionRate;

	private int port;

	public ExchangeValue(Long id, String from, String to, BigDecimal conversionRate) {
		this.id = id;
		this.from = from;
		this.to = to;
		this.conversionRate = conversionRate;
	}

}
