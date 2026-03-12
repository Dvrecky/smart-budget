package com.github.dvrecky.smartbudget.chat.dto;

import java.math.BigDecimal;

public record TransactionDataResponse(
        String title,
        BigDecimal amount,
        String categoryName
) {
}
