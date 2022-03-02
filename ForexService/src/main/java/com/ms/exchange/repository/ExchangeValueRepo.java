package com.ms.exchange.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ms.exchange.model.ExchangeValue;

@Repository
public interface ExchangeValueRepo extends JpaRepository<ExchangeValue, Long>{
	
	public ExchangeValue findByFromAndTo(String from, String to);
}
