package com.github.dvrecky.smartbudget.transaction_common.dto;


import com.github.dvrecky.smartbudget.common.enums.SupportedCurrency;

public record AccountSummary(
        Long id,
        String name,
        SupportedCurrency currency
) {
}
