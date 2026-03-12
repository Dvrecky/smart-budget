package com.github.dvrecky.smartbudget.category.dto;

import jakarta.validation.constraints.NotNull;

public record ReassignTransactionsRequest(
        @NotNull(message = "Category must be selected")
        Long newCategoryId
) {
}
