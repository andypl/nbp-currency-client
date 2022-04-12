package pl.info.czerniak.nbpcurrencyclient.mapper;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.json.JSONArray;
import pl.info.czerniak.nbpcurrencyclient.model.ExchangeRates;
import pl.info.czerniak.nbpcurrencyclient.model.Rate;
import pl.info.czerniak.nbpcurrencyclient.model.Table;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

public class ExchangeRatesArrayMapper {
    public ExchangeRates map(String exchangeRateArray) throws JsonProcessingException {
        JSONArray array = new JSONArray(exchangeRateArray);
        JSONArray rates = array.getJSONObject(0).getJSONArray("rates");

        return new ExchangeRates(
                Table.C,
                getJSONHeaderParam(array, "no"),
                convertParamToLocalDate(array, "tradingDate"),
                convertParamToLocalDate(array, "effectiveDate"),
                exstractRatesFromJSONArray(rates, "rates"));
    }

    private String getJSONHeaderParam(JSONArray jsonArray, String type) {
        return jsonArray.getJSONObject(0).get(type).toString();
    }

    private LocalDate convertParamToLocalDate(JSONArray jsonArray, String type) {
        return LocalDate.parse(getJSONHeaderParam(jsonArray, type));
    }

    private Set<Rate> exstractRatesFromJSONArray(JSONArray rates, String type) throws JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper();
        Set<Rate> rateSet = new HashSet<>();
        for(int i = 0; i< rates.length(); i++) {
            Rate rate = mapper.readValue(rates.getJSONObject(i).toString(), Rate.class);
            rateSet.add(rate);
        }
        return rateSet;
    }
}
