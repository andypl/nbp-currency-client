package pl.info.czerniak.nbpcurrencyclient.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.info.czerniak.nbpcurrencyclient.model.ExchangeRates;
import pl.info.czerniak.nbpcurrencyclient.service.CurrencyService;

@RestController
@RequiredArgsConstructor
public class CurrencyController {
    private final CurrencyService currencyService;
    @GetMapping("/exchangeRates")
    public ExchangeRates getExchangeRates() throws JsonProcessingException {
        return currencyService.getRates();
    }
}
