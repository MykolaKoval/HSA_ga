package com.course.hsa.client.ga.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class GaEventPayload {

    @JsonProperty("client_id")
    private String clientId;
    @JsonProperty("non_personalized_ads")
    private boolean nonPersonalizedAds;
    private List<GaEvent> events;
}
