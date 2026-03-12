package com.github.dvrecky.smartbudget.analytics.dto;

import java.math.BigDecimal;

public record CategoryBreakdownPointDto(
        String categoryName,
        BigDecimal amount
) {}
