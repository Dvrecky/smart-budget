package com.github.dvrecky.smartbudget.transaction.events;

import com.github.dvrecky.smartbudget.notification.domain.NotificationType;

import java.math.BigDecimal;

public record BudgetExceededEvent(
        Long userId,
        NotificationType type,
        Long accountId,
        String accountName,
        BigDecimal transactionAmount,
        BigDecimal currentUsage,
        BigDecimal budgetLimit
) {
}
