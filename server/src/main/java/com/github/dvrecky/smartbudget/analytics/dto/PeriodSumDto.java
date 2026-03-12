package com.github.dvrecky.smartbudget.analytics.dto;

import java.math.BigDecimal;

public record PeriodSumDto(
        Integer year,
        Integer month,
        BigDecimal amount
) {
}
