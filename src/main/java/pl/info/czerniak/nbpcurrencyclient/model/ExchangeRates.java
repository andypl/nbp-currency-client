package pl.info.czerniak.nbpcurrencyclient.model;

import java.time.LocalDate;
import java.util.Set;

public record ExchangeRates(Table table,
                            String no,
                            LocalDate tradingDate,
                            LocalDate effectiveDate,
                            Set<Rate> rates) {}
