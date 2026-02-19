package com.in28minutes.microservices.currencyexchangeservice.resource;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.math.BigDecimal;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import com.in28minutes.microservices.currencyexchangeservice.bean.ExchangeValue;
import com.in28minutes.microservices.currencyexchangeservice.repository.ExchangeValueRepository;
import com.in28minutes.microservices.currencyexchangeservice.util.environment.InstanceInformationService;

@WebMvcTest(CurrencyExchangeController.class)
class CurrencyExchangeControllerTest {

    @Autowired
    private MockMvc mvc;

    @MockBean
    private ExchangeValueRepository repository;

    @MockBean
    private InstanceInformationService instanceInformationService;

    @Test
    void imHealthy() throws Exception {
        mvc.perform(get("/"))
                .andExpect(status().isOk());
    }

    @Test
    void retrieveExchangeValue() throws Exception {

        Mockito.when(repository.findByFromAndTo("EUR", "INR"))
                .thenReturn(new ExchangeValue(
                        1L,   // ✅ FIXED (was Long.getLong("1"))
                        "EUR",
                        "INR",
                        BigDecimal.valueOf(80.00)
                ));

        mvc.perform(get("/currency-exchange/from/EUR/to/INR"))
                .andExpect(status().isOk());
    }
}
