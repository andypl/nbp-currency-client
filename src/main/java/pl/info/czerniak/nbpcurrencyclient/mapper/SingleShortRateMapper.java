package pl.info.czerniak.nbpcurrencyclient.mapper;

import pl.info.czerniak.nbpcurrencyclient.model.RateCode;
import pl.info.czerniak.nbpcurrencyclient.model.RateType;
import pl.info.czerniak.nbpcurrencyclient.model.SingleRate;
import pl.info.czerniak.nbpcurrencyclient.model.SingleShortRate;

import java.math.BigDecimal;

public class SingleShortRateMapper {
    public SingleShortRate map(SingleRate singleRate, RateType rateType) {
        return SingleShortRate.builder()
                .rateCode(RateCode.valueOf(singleRate.currencyCode()))
                .queryDate(singleRate.effectiveDate())
                .value(getRateValueByType(singleRate, rateType))
                .build();
    }
    private BigDecimal getRateValueByType(SingleRate singleRate, RateType rateType) {
        return rateType.equals(RateType.ASK) ? singleRate.ask() : singleRate.bid();
    }
}
