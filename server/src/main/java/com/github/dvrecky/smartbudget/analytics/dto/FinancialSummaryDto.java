package com.github.dvrecky.smartbudget.analytics.dto;

import java.math.BigDecimal;
import java.util.List;

public record FinancialSummaryDto(
    BigDecimal closingBalance,
    BigDecimal totalIncome,
    BigDecimal totalExpense,
    BigDecimal netSavings,
    List<AccountSummaryDto> accounts,
    List<TransactionSummaryDto> recentTransactions
)
{}
