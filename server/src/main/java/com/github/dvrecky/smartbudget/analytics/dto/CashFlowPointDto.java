package com.github.dvrecky.smartbudget.analytics.dto;

import java.math.BigDecimal;
import java.time.LocalDate;

public record CashFlowPointDto(
        LocalDate date,
        BigDecimal totalIncome,
        BigDecimal totalExpense
) {
}
