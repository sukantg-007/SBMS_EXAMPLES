package com.vc.ms;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "Exchange_Value")
public class ExchangeValue {

	@Id
	@Column(name = "id")
	private Long id;
	@Column(name = "currency_from")
	private String from;
	@Column(name = "currency_to")
	private String to;
	@Column(name = "conversion_multiple")
	private BigDecimal conversionMultiple;
	@Column(name = "port")
	private int port;
}
