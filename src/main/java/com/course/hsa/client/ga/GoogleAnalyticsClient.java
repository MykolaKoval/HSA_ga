package com.course.hsa.client.ga;

import com.course.hsa.client.ga.dto.GaEventPayload;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(name = "${client.ga.name}", url = "${client.ga.url}")
public interface GoogleAnalyticsClient {

    @PostMapping(path = "/mp/collect",
            params = {
                    "measurement_id=${client.ga.measurement-id}",
                    "api_secret=${client.ga.api-secret}"
            },
            produces = MediaType.APPLICATION_JSON_VALUE)
    void publishExchangeRate(@RequestBody GaEventPayload payload);
}
