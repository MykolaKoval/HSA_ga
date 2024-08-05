package com.course.hsa.client.ga.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class GaExchangeRateParam {

    @JsonProperty("exchange_rate")
    private String value;
}
