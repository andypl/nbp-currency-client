package pl.info.czerniak.nbpcurrencyclient.model;

import lombok.Builder;

import java.math.BigDecimal;
import java.time.LocalDate;
@Builder
public record SingleShortRate(RateCode rateCode,
                              LocalDate queryDate,
                              BigDecimal value) {
}
