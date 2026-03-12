package com.github.dvrecky.smartbudget.analytics.dto;

import java.math.BigDecimal;

public record PeriodSumCashFlowDto(
        Integer year,
        Integer month,
        BigDecimal totalIncome,
        BigDecimal totalExpense
) {
}
