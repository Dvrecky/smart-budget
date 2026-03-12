package com.github.dvrecky.smartbudget.account.dto;

import com.github.dvrecky.smartbudget.account.domain.AccountStatus;
import com.github.dvrecky.smartbudget.account.domain.AccountType;
import com.github.dvrecky.smartbudget.account.domain.BudgetType;
import com.github.dvrecky.smartbudget.common.enums.SupportedCurrency;

import java.math.BigDecimal;
import java.time.Instant;

public record AccountDetailsResponse(
        Long id,
        AccountType type,
        String name,
        BigDecimal balance,
        BigDecimal totalIncome,
        BigDecimal totalExpense,
        SupportedCurrency currency,
        Boolean isDefault,
        String description,
        BudgetType budgetType,
        BigDecimal budget,
        Double alertThreshold,
        String iconPath,
        Boolean includeInTotalBalance,
        Instant createdAt,
        AccountStatus status,
        boolean hasTransactions
) {
}
