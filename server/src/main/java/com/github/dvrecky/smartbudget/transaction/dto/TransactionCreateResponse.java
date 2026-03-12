package com.github.dvrecky.smartbudget.transaction.dto;

import java.time.LocalDateTime;

public record TransactionCreateResponse(
        long id,
        LocalDateTime transactionDate
) {
}
