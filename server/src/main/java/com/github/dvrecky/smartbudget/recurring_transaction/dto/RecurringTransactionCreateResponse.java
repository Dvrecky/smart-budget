package com.github.dvrecky.smartbudget.recurring_transaction.dto;

import com.github.dvrecky.smartbudget.transaction.dto.TransactionSummary;

import java.time.LocalDate;

public record RecurringTransactionCreateResponse(
        long id,
        LocalDate nextOccurrence,
        boolean isActive,
        boolean newTransaction,
        TransactionSummary newTransactionView
) {
}
