package com.github.dvrecky.smartbudget.recurring_transaction.dto;

import jakarta.validation.constraints.NotNull;

public record RecurringTransactionStatusUpdateRequest(
        @NotNull(message = "Status is required")
        Boolean isActive
) {
}
