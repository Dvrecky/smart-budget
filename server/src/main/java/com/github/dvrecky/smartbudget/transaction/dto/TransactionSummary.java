package com.github.dvrecky.smartbudget.transaction.dto;

import com.github.dvrecky.smartbudget.transaction_common.domain.TransactionType;
import com.github.dvrecky.smartbudget.transaction_common.dto.AccountSummary;
import com.github.dvrecky.smartbudget.transaction_common.dto.CategorySummary;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public record TransactionSummary(
        Long id,
        String title,
        BigDecimal amount,
        TransactionType type,
        String description,
        LocalDateTime transactionDate,
        AccountSummary account,
        CategorySummary category,
        Long recurringTransactionId,
        Boolean hasAttachment
) {
}
