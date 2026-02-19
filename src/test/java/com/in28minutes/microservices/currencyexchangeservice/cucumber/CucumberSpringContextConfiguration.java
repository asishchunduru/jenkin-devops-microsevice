package com.in28minutes.microservices.currencyexchangeservice.cucumber;

import io.cucumber.java.Before;
import io.cucumber.spring.CucumberContextConfiguration;

import org.springframework.boot.test.context.SpringBootTest;

import com.in28minutes.microservices.currencyexchangeservice.CurrencyExchangeServiceApplicationH2;

@CucumberContextConfiguration
@SpringBootTest(
        classes = CurrencyExchangeServiceApplicationH2.class,
        webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT
)
public class CucumberSpringContextConfiguration {

    @Before
    public void setUp() {
        // Setup logic if needed
    }
}
