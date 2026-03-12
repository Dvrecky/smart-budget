package com.github.dvrecky.smartbudget.common.reference.controller;


import com.github.dvrecky.smartbudget.account.domain.AccountStatus;
import com.github.dvrecky.smartbudget.account.domain.AccountType;
import com.github.dvrecky.smartbudget.account.domain.BudgetType;
import com.github.dvrecky.smartbudget.category.domain.CategoryType;
import com.github.dvrecky.smartbudget.common.enums.SupportedCurrency;
import com.github.dvrecky.smartbudget.common.storage.service.StorageService;
import com.github.dvrecky.smartbudget.common.storage.config.IconConfig;
import com.github.dvrecky.smartbudget.notification.domain.NotificationType;
import com.github.dvrecky.smartbudget.session.domain.DeviceType;
import com.github.dvrecky.smartbudget.user.domain.UserStatus;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/api/v1/reference-data")
@RequiredArgsConstructor
public class ReferenceDataController {

    private final IconConfig iconConfig;
    private final StorageService storageService;

    @GetMapping
    public ResponseEntity<ReferenceDataResponse> getReferenceData() {
        return ResponseEntity.ok(new ReferenceDataResponse(
                Arrays.stream(AccountType.values()).map(Enum::name).toList(),
                Arrays.stream(BudgetType.values()).map(Enum::name).toList(),
                Arrays.stream(SupportedCurrency.values()).map(Enum::name).toList(),
                Arrays.stream(CategoryType.values()).map(Enum::name).toList(),
                Arrays.stream(DeviceType.values()).map(Enum::name).toList(),
                Arrays.stream(UserStatus.values()).map(Enum::name).toList(),
                Arrays.stream(AccountStatus.values()).map(Enum::name).toList(),
                iconConfig.getAccounts().stream()
                        .map(storageService::getPublicUrl)
                        .toList(),

                iconConfig.getCategories().stream()
                        .map(storageService::getPublicUrl)
                        .toList(),
                Arrays.stream(NotificationType.values()).map(Enum::name).toList()
        ));
    }

    public record ReferenceDataResponse(
            List<String> accountTypes,
            List<String> budgetTypes,
            List<String> currencies,
            List<String> categoryTypes,
            List<String> deviceTypes,
            List<String> userStatuses,
            List<String> accountStatuses,
            List<String> accountIcons,
            List<String> categoryIcons,
            List<String> notificationsTypes
    ) {
    }

}
