package pl.info.czerniak.nbpcurrencyclient.mapper;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.json.JSONArray;
import pl.info.czerniak.nbpcurrencyclient.model.ExchangeRates;
import pl.info.czerniak.nbpcurrencyclient.model.ExchangeRatesHeaderEnum;
import pl.info.czerniak.nbpcurrencyclient.model.Rate;
import pl.info.czerniak.nbpcurrencyclient.model.Table;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

import static pl.info.czerniak.nbpcurrencyclient.model.ExchangeRatesHeaderEnum.EFFECTIVE_DATE;
import static pl.info.czerniak.nbpcurrencyclient.model.ExchangeRatesHeaderEnum.NO;
import static pl.info.czerniak.nbpcurrencyclient.model.ExchangeRatesHeaderEnum.TRADING_DATE;

public class ExchangeRatesArrayMapper {
    public ExchangeRates map(String exchangeRateArray) throws JsonProcessingException {
        JSONArray array = new JSONArray(exchangeRateArray);
        JSONArray rates = array.getJSONObject(0).getJSONArray("rates");

        return new ExchangeRates(
                Table.C,
                getJSONHeaderParam(array, NO),
                convertParamToLocalDate(array, TRADING_DATE),
                convertParamToLocalDate(array, EFFECTIVE_DATE),
                exstractRatesFromJSONArray(rates));
    }

    private String getJSONHeaderParam(JSONArray jsonArray, ExchangeRatesHeaderEnum type) {
        return jsonArray.getJSONObject(0).get(type.getDescription()).toString();
    }

    private LocalDate convertParamToLocalDate(JSONArray jsonArray, ExchangeRatesHeaderEnum type) {
        return LocalDate.parse(getJSONHeaderParam(jsonArray, type));
    }

    private Set<Rate> exstractRatesFromJSONArray(JSONArray rates) {
        ObjectMapper mapper = new ObjectMapper();
        Set<Rate> result = new HashSet<>();
        for(int i = 0; i< rates.length(); i++) {
            Rate rate;
            try {
                rate = mapper.readValue(rates.getJSONObject(i).toString(), Rate.class);
            } catch (JsonProcessingException e) {
                throw new RuntimeException(e); //TODO Catch exceptions using a Interceptor and print all it
            }
            result.add(rate);
        }
        return result;
    }
}
