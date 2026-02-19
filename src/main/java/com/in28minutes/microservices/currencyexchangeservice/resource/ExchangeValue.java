package com.in28minutes.microservices.currencyexchangeservice.resource;

import java.math.BigDecimal;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "exchange_value")
public class ExchangeValue {

    @Id
    private Long id;

    @Column(name = "currency_from")
    private String fromCurrency;

    @Column(name = "currency_to")
    private String toCurrency;

    @Column(name = "conversion_multiple")
    private BigDecimal conversionMultiple;

    private String exchangeEnvironmentInfo;

    // Default constructor
    public ExchangeValue() {
    }

    // Constructor without environment info
    public ExchangeValue(Long id, String fromCurrency, String toCurrency, BigDecimal conversionMultiple) {
        this.id = id;
        this.fromCurrency = fromCurrency;
        this.toCurrency = toCurrency;
        this.conversionMultiple = conversionMultiple;
    }

    // Getters
    public Long getId() {
        return id;
    }

    public String getFromCurrency() {
        return fromCurrency;
    }

    public String getToCurrency() {
        return toCurrency;
    }

    public BigDecimal getConversionMultiple() {
        return conversionMultiple;
    }

    public String getExchangeEnvironmentInfo() {
        return exchangeEnvironmentInfo;
    }

    // Setter
    public void setExchangeEnvironmentInfo(String exchangeEnvironmentInfo) {
        this.exchangeEnvironmentInfo = exchangeEnvironmentInfo + " updated";
    }

    @Override
    public String toString() {
        return "ExchangeValue [id=" + id + ", fromCurrency=" + fromCurrency + ", toCurrency=" + toCurrency
                + ", conversionMultiple=" + conversionMultiple + ", exchangeEnvironmentInfo=" + exchangeEnvironmentInfo
                + "]";
    }
}
