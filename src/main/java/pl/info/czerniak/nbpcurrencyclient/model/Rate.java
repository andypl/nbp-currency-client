package pl.info.czerniak.nbpcurrencyclient.model;

import java.math.BigDecimal;

public record Rate(String currency,
                   RateCode rateCode,
                   BigDecimal bid,
                   BigDecimal ask) {
}
