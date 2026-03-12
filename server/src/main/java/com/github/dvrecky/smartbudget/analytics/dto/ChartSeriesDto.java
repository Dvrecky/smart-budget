package com.github.dvrecky.smartbudget.analytics.dto;

import java.math.BigDecimal;
import java.util.List;

public record ChartSeriesDto(
        String label,
        List<BigDecimal> data
) {
}
