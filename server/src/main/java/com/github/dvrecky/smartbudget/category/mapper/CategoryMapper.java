package com.github.dvrecky.smartbudget.category.mapper;

import com.github.dvrecky.smartbudget.category.domain.Category;
import com.github.dvrecky.smartbudget.category.dto.CategoryResponse;
import com.github.dvrecky.smartbudget.common.storage.service.StorageService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class CategoryMapper {

    private final StorageService storageService;

    public CategoryResponse toCategoryResponse(Category category) {
        return new CategoryResponse(
                category.getId(),
                category.getName(),
                category.getType(),
                category.isDefault(),
                storageService.getPublicUrl(category.getIconKey())
        );
    }
}
