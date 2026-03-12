package com.github.dvrecky.smartbudget.recurring_transaction.mapper;

import com.github.dvrecky.smartbudget.account.domain.Account;
import com.github.dvrecky.smartbudget.category.domain.Category;
import com.github.dvrecky.smartbudget.common.enums.SupportedCurrency;
import com.github.dvrecky.smartbudget.common.storage.service.StorageService;
import com.github.dvrecky.smartbudget.recurring_transaction.domain.RecurringInterval;
import com.github.dvrecky.smartbudget.recurring_transaction.domain.RecurringTransaction;
import com.github.dvrecky.smartbudget.recurring_transaction.dto.RecurringTransactionDetailsResponse;
import com.github.dvrecky.smartbudget.recurring_transaction.dto.RecurringTransactionSummary;
import com.github.dvrecky.smartbudget.recurring_transaction.dto.UpcomingTransactionSummary;
import com.github.dvrecky.smartbudget.transaction.domain.Transaction;
import com.github.dvrecky.smartbudget.transaction.dto.TransactionSummary;
import com.github.dvrecky.smartbudget.transaction_common.domain.TransactionType;
import com.github.dvrecky.smartbudget.transaction_common.dto.AccountSummary;
import com.github.dvrecky.smartbudget.transaction_common.dto.CategorySummary;
import jakarta.persistence.Tuple;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

@Component
@RequiredArgsConstructor
public class RecurringTransactionMapper {

    private final StorageService storageService;

    public List<RecurringTransactionSummary> fromTuples(List<Tuple> tuples) {

        return tuples.stream()
                .map( tuple -> new RecurringTransactionSummary(
                        tuple.get("recId", Long.class),
                        tuple.get("title", String.class),
                        tuple.get("amount", BigDecimal.class),
                        tuple.get("type", TransactionType.class),
                        tuple.get("isActive", Boolean.class),
                        tuple.get("desc", String.class),
                        tuple.get("nextOccurrence", LocalDate.class),
                        tuple.get("recInterval", RecurringInterval.class),
                        tuple.get("recValue", Integer.class),
                        new AccountSummary(
                                tuple.get("accountId", Long.class),
                                tuple.get("accountName", String.class),
                                tuple.get("currency", SupportedCurrency.class)
                        ),
                        new CategorySummary(
                                tuple.get("categoryId", Long.class),
                                tuple.get("categoryName", String.class),
                                storageService.getPublicUrl(tuple.get("iconKey", String.class))
                        )
                )).toList();
    }

    public List<UpcomingTransactionSummary> fromUpcomingTuples(List<Tuple> tuples) {
        return tuples.stream()
                .map( tuple -> new UpcomingTransactionSummary(
                        tuple.get("recurringTemplateId", Long.class),
                        tuple.get("amount", BigDecimal.class),
                        tuple.get("title", String.class),
                        tuple.get("type", TransactionType.class),
                        tuple.get("nextOccurrence", LocalDate.class),
                        new AccountSummary(
                                tuple.get("accountId", Long.class),
                                tuple.get("accountName", String.class),
                                tuple.get("currency", SupportedCurrency.class)
                        ),
                        new CategorySummary(
                                tuple.get("categoryId", Long.class),
                                tuple.get("categoryName", String.class),
                                storageService.getPublicUrl(tuple.get("iconKey", String.class))
                        )
                )).toList();
    }

    public RecurringTransactionDetailsResponse toDetails(RecurringTransaction recurringTransaction) {
        return new RecurringTransactionDetailsResponse(
                recurringTransaction.getNextOccurrence(),
                recurringTransaction.getStartDate(),
                recurringTransaction.getEndDate(),
                recurringTransaction.getCreatedAt());
    }

    public TransactionSummary toTransactionView(Transaction transaction, Long recTransactionId) {
        Account account = transaction.getAccount();
        Category category = transaction.getCategory();
        return new TransactionSummary(transaction.getId(), transaction.getTitle(), transaction.getAmount(), transaction.getType(), transaction.getDescription(), transaction.getTransactionDate(),
                new AccountSummary(account.getId(), account.getName(), account.getCurrency()),
                new CategorySummary(category.getId(), category.getName(), category.getIconKey()), recTransactionId, false);
    }
}
