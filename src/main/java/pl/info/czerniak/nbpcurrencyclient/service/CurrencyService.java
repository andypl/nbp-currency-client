package pl.info.czerniak.nbpcurrencyclient.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import pl.info.czerniak.nbpcurrencyclient.mapper.ExchangeRatesArrayMapper;
import pl.info.czerniak.nbpcurrencyclient.model.ExchangeRates;

@Service
@Slf4j
public class CurrencyService {

    private final RestTemplate restTemplate = new RestTemplate();
    public ExchangeRates getRates() throws JsonProcessingException {
        String response = restTemplate.getForObject("http://api.nbp.pl/api/exchangerates/tables/C?format=json", String.class);

        return new ExchangeRatesArrayMapper().map(response);

    }
}
