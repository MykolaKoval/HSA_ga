package com.course.hsa.scheduler;

import com.course.hsa.domain.Currency;
import com.course.hsa.service.CurrencyService;
import com.course.hsa.service.PublishService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@RequiredArgsConstructor
public class GaTaskScheduler {

    private final CurrencyService currencyService;
    private final PublishService publishService;

    @Scheduled(cron = "${scheduler.ga.publish-exchange-rate.schedule}")
    public void publishGaExchangeRate() {
        log.info("Publish GA exchange rate event is triggered..");
        var exchangeRate = currencyService.getUahExchangeRate(Currency.USD);
        publishService.publishExchangeRate(exchangeRate);
    }
}
