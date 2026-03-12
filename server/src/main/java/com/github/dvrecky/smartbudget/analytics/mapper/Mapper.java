package com.github.dvrecky.smartbudget.analytics.mapper;

import com.github.dvrecky.smartbudget.account.domain.Account;
import com.github.dvrecky.smartbudget.analytics.dto.AccountSummaryDto;
import com.github.dvrecky.smartbudget.analytics.dto.TransactionSummaryDto;
import com.github.dvrecky.smartbudget.common.enums.SupportedCurrency;
import com.github.dvrecky.smartbudget.common.storage.service.StorageService;
import com.github.dvrecky.smartbudget.transaction_common.domain.TransactionType;
import jakarta.persistence.Tuple;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Component
@RequiredArgsConstructor
public class Mapper {

    private final StorageService storageService;

    public TransactionSummaryDto toTransactionSummary(Tuple tuple) {
        return new TransactionSummaryDto(
                tuple.get("title", String.class),
                tuple.get("amount", BigDecimal.class),
                tuple.get("type", TransactionType.class),
                tuple.get("transactionDate", LocalDateTime.class),
                tuple.get("categoryName", String.class),
                storageService.getPublicUrl(tuple.get("iconKey", String.class)),
                tuple.get("accountName", String.class),
                tuple.get("currency", SupportedCurrency.class)
        );
    }

    public AccountSummaryDto toAccountSummary(Account account) {
        return new AccountSummaryDto(
                account.getId(),
                account.getName(),
                account.getBalance(),
                account.getCurrency(),
                account.getAccountType(),
                account.isIncludeInTotalBalance(),
                storageService.getPublicUrl(account.getIconKey())
        );
    }
}
