package com.course.hsa.client.nbu;

import com.course.hsa.domain.ExchangeRate;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@FeignClient(name = "${client.nbu.name}", url = "${client.nbu.url}")
public interface NbuClient {

    @GetMapping(path = "NBU_Exchange/exchange?json")
    List<ExchangeRate> getUahExchangeRate();
}
