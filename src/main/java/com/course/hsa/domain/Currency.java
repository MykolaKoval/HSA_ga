package com.course.hsa.domain;

import java.util.Arrays;
import java.util.Objects;

public enum Currency {
    USD, EUR, GBP;

    public static Currency from(String value) {
        return Arrays.stream(Currency.values())
                .filter(source -> Objects.equals(source.name(), value))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException(String.format("Currency not supported", value)));
    }
}
