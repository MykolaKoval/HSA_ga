package com.course.hsa.service;

import com.course.hsa.client.ga.GoogleAnalyticsClient;
import com.course.hsa.client.ga.dto.GaEvent;
import com.course.hsa.client.ga.dto.GaEventPayload;
import com.course.hsa.client.ga.dto.GaExchangeRateParam;
import com.course.hsa.domain.ExchangeRate;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class PublishService {

    private static final String GA_EVENT_NAME = "currency_event";

    @Value("${client.ga.client-id}")
    private final String gaClientId;
    private final GoogleAnalyticsClient gaClient;
    private final ObjectMapper objectMapper;

    public void publishExchangeRate(ExchangeRate exchangeRate) {
        var exchangeRateValue = exchangeRate.getAmount().toString();
        log.info("Exchange rate to be sent: {}", exchangeRateValue);
        var gaEvent = GaEvent.builder()
                .name(GA_EVENT_NAME)
                .params(new GaExchangeRateParam(exchangeRateValue))
                .build();
        var gaPayload = GaEventPayload.builder().clientId(gaClientId).events(List.of(gaEvent)).build();
        logPayload(gaPayload);

        gaClient.publishExchangeRate(gaPayload);
    }

    @SneakyThrows
    private void logPayload(GaEventPayload payload) {
        log.info("PAYLOAD: {}", objectMapper.writeValueAsString(payload));
    }
}
