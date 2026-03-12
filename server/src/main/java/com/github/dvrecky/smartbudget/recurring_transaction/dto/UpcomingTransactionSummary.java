package com.github.dvrecky.smartbudget.recurring_transaction.dto;

import com.github.dvrecky.smartbudget.transaction_common.domain.TransactionType;
import com.github.dvrecky.smartbudget.transaction_common.dto.AccountSummary;
import com.github.dvrecky.smartbudget.transaction_common.dto.CategorySummary;

import java.math.BigDecimal;
import java.time.LocalDate;

public record UpcomingTransactionSummary(
        Long recurringTemplateId,
        BigDecimal amount,
        String title,
        TransactionType type,
        LocalDate nextOccurrence,
        AccountSummary accountSummary,
        CategorySummary categorySummary
) {
}
