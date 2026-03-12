package com.github.dvrecky.smartbudget.analytics.dto;

import java.time.LocalDate;
import java.util.List;

public record MultiSeriesChartDto(
        List<LocalDate> dates,
        List<ChartSeriesDto> series
) {
}
