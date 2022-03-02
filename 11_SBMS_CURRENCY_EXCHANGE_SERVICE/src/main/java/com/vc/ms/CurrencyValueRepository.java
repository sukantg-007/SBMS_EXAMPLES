package com.vc.ms;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CurrencyValueRepository extends JpaRepository<CurrencyValue, Long> {

	CurrencyValue findByFromAndTo(String from, String to);
}
