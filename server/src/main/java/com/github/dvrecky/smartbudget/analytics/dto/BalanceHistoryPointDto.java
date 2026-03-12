package com.github.dvrecky.smartbudget.analytics.dto;

import java.math.BigDecimal;
import java.time.LocalDate;

public record BalanceHistoryPointDto(
        LocalDate date,
        BigDecimal amount
) {
}
