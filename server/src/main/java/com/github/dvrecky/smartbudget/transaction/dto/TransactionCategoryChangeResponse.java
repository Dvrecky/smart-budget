package com.github.dvrecky.smartbudget.transaction.dto;

public record TransactionCategoryChangeResponse(
        long categoryId,
        String categoryName,
        String categoryIconPath
) {
}
