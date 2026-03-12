package com.github.dvrecky.smartbudget.category.dto;

import com.github.dvrecky.smartbudget.category.domain.CategoryType;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public record CategoryCreateRequest(
        @NotBlank(message = "Name is required")
        @Size(min = 2, max = 30, message = "Name must be between 2 and 30 characters")
        String name,
        @NotNull(message = "Type is required")
        CategoryType type,
        String iconPath
) {
}
