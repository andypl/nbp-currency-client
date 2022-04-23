package pl.info.czerniak.nbpcurrencyclient.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import pl.info.czerniak.nbpcurrencyclient.model.RateCode;
import pl.info.czerniak.nbpcurrencyclient.model.ExchangeRates;
import pl.info.czerniak.nbpcurrencyclient.model.RateType;
import pl.info.czerniak.nbpcurrencyclient.model.SingleRate;
import pl.info.czerniak.nbpcurrencyclient.model.SingleShortRate;
import pl.info.czerniak.nbpcurrencyclient.service.CurrencyService;

@RestController
@RequiredArgsConstructor
public class CurrencyController {
    private final CurrencyService currencyService;
    @GetMapping("/exchangeRates")
    @ResponseBody
    public ExchangeRates getExchangeRates() throws JsonProcessingException {
        return currencyService.getRates();
    }

    @GetMapping("/exchangeRate/{rateCode}")
    @ResponseBody
    public SingleRate getFullRate(@PathVariable RateCode rateCode) {
        return currencyService.getRate(rateCode);
    }
    @GetMapping("/exchangeRate/{rateCode}/{rateType}")
    @ResponseBody
    public SingleShortRate getRate(@PathVariable RateCode rateCode, @PathVariable RateType rateType) {
        return currencyService.getRateByType(rateCode, rateType);
    }
}
