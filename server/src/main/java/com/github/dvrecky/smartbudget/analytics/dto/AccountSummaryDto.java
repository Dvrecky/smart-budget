package com.github.dvrecky.smartbudget.analytics.dto;

import com.github.dvrecky.smartbudget.account.domain.AccountType;
import com.github.dvrecky.smartbudget.common.enums.SupportedCurrency;

import java.math.BigDecimal;

public record AccountSummaryDto(
        Long id,
        String name,
        BigDecimal balance,
        SupportedCurrency currency,
        AccountType type,
        Boolean includeInTotalBalance,
        String iconPath
) {}
