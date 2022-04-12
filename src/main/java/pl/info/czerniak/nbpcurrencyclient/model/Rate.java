package pl.info.czerniak.nbpcurrencyclient.model;

import java.math.BigDecimal;

public record Rate(String currency,
                   Code code,
                   BigDecimal bid,
                   BigDecimal ask) {
}
