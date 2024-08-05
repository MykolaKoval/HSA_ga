package com.course.hsa.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.time.LocalDate;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class ExchangeRate {

    @JsonFormat(pattern = "dd.MM.yyyy")
    @JsonProperty("StartDate")
    private LocalDate startDate;
    @JsonProperty("CurrencyCode")
    private String currencyCode;
    @JsonProperty("CurrencyCodeL")
    private String currency;
    @JsonProperty("Units")
    private Integer units;
    @JsonProperty("Amount")
    private Double amount;
}
