package pl.info.czerniak.nbpcurrencyclient.model;

import java.math.BigDecimal;
import java.time.LocalDate;

public record SingleRate(Table table,
                         String currencyCode,
                         String currencyDescription,
                         String rateNo,
                         LocalDate effectiveDate,
                         BigDecimal bid,
                         BigDecimal ask) {
}
