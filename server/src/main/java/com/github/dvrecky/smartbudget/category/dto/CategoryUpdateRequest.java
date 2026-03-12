package com.github.dvrecky.smartbudget.category.dto;

import com.github.dvrecky.smartbudget.category.domain.CategoryType;
import jakarta.validation.constraints.Size;

public record CategoryUpdateRequest(
    @Size(min = 2, max = 30, message = "Name must be between 2 and 30 characters")
    String name,
    CategoryType type,
    String iconPath
) {}
