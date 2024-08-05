package com.course.hsa.client.ga.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class GaEvent {

    private String name;
    private GaExchangeRateParam params;
}
