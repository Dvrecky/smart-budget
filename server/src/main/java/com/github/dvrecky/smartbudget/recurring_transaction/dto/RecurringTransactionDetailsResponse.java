package com.github.dvrecky.smartbudget.recurring_transaction.dto;

import java.time.LocalDate;
import java.time.LocalDateTime;

public record RecurringTransactionDetailsResponse(
        LocalDate nextOccurrence,
        LocalDate startDate,
        LocalDate endDate,
        LocalDateTime createdAt
) {
}
