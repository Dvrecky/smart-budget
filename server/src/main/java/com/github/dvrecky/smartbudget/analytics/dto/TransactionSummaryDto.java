package com.github.dvrecky.smartbudget.analytics.dto;

import com.github.dvrecky.smartbudget.common.enums.SupportedCurrency;
import com.github.dvrecky.smartbudget.transaction_common.domain.TransactionType;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public record TransactionSummaryDto(
        String title,
        BigDecimal amount,
        TransactionType type,
        LocalDateTime date,
        String categoryName,
        String categoryIconPath,
        String accountName,
        SupportedCurrency currency
) {
}
