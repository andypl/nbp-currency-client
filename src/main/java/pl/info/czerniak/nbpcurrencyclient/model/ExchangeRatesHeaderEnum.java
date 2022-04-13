package pl.info.czerniak.nbpcurrencyclient.model;

import lombok.Getter;

@Getter
public enum ExchangeRatesHeaderEnum {
    NO("no"),
    TRADING_DATE("tradingDate"),
    EFFECTIVE_DATE("effectiveDate"),
    RATES("rates");

    private final String description;

    ExchangeRatesHeaderEnum(String description) {
        this.description = description;
    }
}
