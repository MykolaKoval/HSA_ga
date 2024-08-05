package com.course.hsa.controller;

import com.course.hsa.domain.Currency;
import com.course.hsa.domain.ExchangeRate;
import com.course.hsa.service.CurrencyService;
import com.course.hsa.service.PublishService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@RequiredArgsConstructor
public class CurrencyController {

    private final CurrencyService currencyService;
    private final PublishService publishService;

    @GetMapping(path = "/uah/exchangeRate")
    public ExchangeRate getUahExchangeRate(@RequestParam(name = "currency", required = false) String currency) {
        var requestedCurrency = Optional.ofNullable(currency).map(Currency::from).orElse(Currency.USD);
        return currencyService.getUahExchangeRate(requestedCurrency);
    }

    @PostMapping(path = "/publishExchangeRate")
    public void publishExchangeRate() {
        var exchangeRate = currencyService.getUahExchangeRate(Currency.USD);
        publishService.publishExchangeRate(exchangeRate);
    }
}
