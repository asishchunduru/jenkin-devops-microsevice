package com.in28minutes.microservices.currencyexchangeservice.resource;

import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

import com.in28minutes.microservices.currencyexchangeservice.util.environment.InstanceInformationService;

@RestController
public class CurrencyExchangeController {

    private static final Logger LOGGER = LoggerFactory.getLogger(CurrencyExchangeController.class);

    @Autowired
    private ExchangeValueRepository repository;

    @Autowired
    private InstanceInformationService instanceInformationService;

    // Health check endpoint
    @GetMapping("/")
    public ResponseEntity<String> imHealthy() {
        return ResponseEntity.ok("{\"healthy\": true}");
    }

    // Example: http://localhost:8000/currency-exchange/from/USD/to/INR
    @GetMapping("/currency-exchange/from/{from}/to/{to}")
    public ResponseEntity<ExchangeValue> retrieveExchangeValue(
            @PathVariable("from") String fromCurrency,
            @PathVariable("to") String toCurrency,
            @RequestHeader Map<String, String> headers) {

        printAllHeaders(headers);

        // Retrieve from database
        ExchangeValue exchangeValue = repository.findByFromAndTo(fromCurrency, toCurrency);

        LOGGER.info("Currency exchange request: {} -> {} | {}", fromCurrency, toCurrency, exchangeValue);

        if (exchangeValue == null) {
            return ResponseEntity.notFound()
                    .build();
        }

        // Add environment info
        exchangeValue.setExchangeEnvironmentInfo(instanceInformationService.retrieveInstanceInfo());

        return ResponseEntity.ok(exchangeValue);
    }

    private void printAllHeaders(Map<String, String> headers) {
        headers.forEach((key, value) -> LOGGER.info("Header '{}' = {}", key, value));
    }
}
