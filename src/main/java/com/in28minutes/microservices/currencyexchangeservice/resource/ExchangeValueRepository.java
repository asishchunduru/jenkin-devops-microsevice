package com.in28minutes.microservices.currencyexchangeservice.resource;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ExchangeValueRepository extends JpaRepository<ExchangeValue, Long> {

    // Corrected method names to match entity field names
    ExchangeValue findByFromCurrencyAndToCurrency(String fromCurrency, String toCurrency);

}
