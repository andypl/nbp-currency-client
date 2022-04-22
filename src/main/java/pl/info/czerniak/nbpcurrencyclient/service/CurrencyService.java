package pl.info.czerniak.nbpcurrencyclient.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import pl.info.czerniak.nbpcurrencyclient.mapper.ExchangeRatesArrayMapper;
import pl.info.czerniak.nbpcurrencyclient.model.RateCode;
import pl.info.czerniak.nbpcurrencyclient.model.ExchangeRates;
import pl.info.czerniak.nbpcurrencyclient.model.RateType;
import pl.info.czerniak.nbpcurrencyclient.model.SingleRate;

import java.util.HashMap;
import java.util.Map;

@Service
@Slf4j
public class CurrencyService {

    private final RestTemplate restTemplate = new RestTemplate();
    public ExchangeRates getRates() throws JsonProcessingException {
        String response = restTemplate.getForObject("http://api.nbp.pl/api/exchangerates/tables/C?format=json", String.class);

        return new ExchangeRatesArrayMapper().map(response);

    }

    public SingleRate getRate(RateCode rateCode, RateType rateType) {
        Map<String, String> uriVariables = new HashMap<>();
        uriVariables.put("rateTable", "C");
        uriVariables.put("rateCode", rateCode.toString());
        String response = restTemplate.getForObject("http://api.nbp.pl/api/exchangerates/rates/{rateTable}/{rateCode}?format=json", String.class, uriVariables);

        return new SingleRateMapper().map(response);
    }
}

