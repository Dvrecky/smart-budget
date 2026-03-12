package com.github.dvrecky.smartbudget.category.service;

import com.github.dvrecky.smartbudget.category.domain.CategoryType;
import com.github.dvrecky.smartbudget.category.dto.CategoryCreateRequest;
import com.github.dvrecky.smartbudget.category.dto.CategoryResponse;
import com.github.dvrecky.smartbudget.category.dto.CategoryUpdateRequest;
import com.github.dvrecky.smartbudget.user.domain.User;

import java.util.List;

public interface CategoryService {

    List<CategoryResponse> getCategories(Long userId, CategoryType type);

    CategoryResponse getCategory(Long userId, Long categoryId);

    CategoryResponse createCategory(Long userId, CategoryCreateRequest dto);

    CategoryResponse updateCategory(Long userId, Long categoryId, CategoryUpdateRequest dto);

    void deleteCategory(Long userId, Long categoryId);

    void assignInitialCategories(User user);

    void deleteAllByUser(Long userId);

    void reassignTransactions(Long userId, Long oldCategoryId, Long newCategoryId);
}
