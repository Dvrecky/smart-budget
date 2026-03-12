package com.github.dvrecky.smartbudget.recurring_transaction.dto;

import com.github.dvrecky.smartbudget.recurring_transaction.domain.RecurringInterval;
import com.github.dvrecky.smartbudget.transaction_common.domain.TransactionType;
import com.github.dvrecky.smartbudget.transaction_common.dto.AccountSummary;
import com.github.dvrecky.smartbudget.transaction_common.dto.CategorySummary;

import java.math.BigDecimal;
import java.time.LocalDate;

public record RecurringTransactionSummary(
        long id,
        String title,
        BigDecimal amount,
        TransactionType type,
        boolean isActive,
        String description,
        LocalDate nextOccurrence,
        RecurringInterval recurringInterval,
        int recurringValue,
        AccountSummary accountSummary,
        CategorySummary categorySummary
) {
}
