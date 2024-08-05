package com.course.hsa.service;

import com.course.hsa.client.nbu.NbuClient;
import com.course.hsa.domain.Currency;
import com.course.hsa.domain.ExchangeRate;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CurrencyService {

    private final NbuClient nbuClient;

    public ExchangeRate getUahExchangeRate(Currency currency) {
        return nbuClient.getUahExchangeRate()
                .stream()
                .filter(rate -> rate.getCurrency().equals(currency.name()))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException(String.format("Currency not found: %s", currency.name())));
    }
}
