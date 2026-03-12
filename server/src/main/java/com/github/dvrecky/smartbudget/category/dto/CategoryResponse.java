package com.github.dvrecky.smartbudget.category.dto;

import com.github.dvrecky.smartbudget.category.domain.CategoryType;

public record CategoryResponse(
        Long id,
        String name,
        CategoryType type,
        Boolean isDefault,
        String iconPath
) {
}
