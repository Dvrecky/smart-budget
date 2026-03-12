package com.github.dvrecky.smartbudget.recurring_transaction.scheduler;

import com.github.dvrecky.smartbudget.recurring_transaction.service.RecurringTransactionService;
import lombok.RequiredArgsConstructor;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class TransactionScheduler {

    private final RecurringTransactionService recurringTransactionService;

    @Scheduled(cron = "0 0 0 * * ?")
    public void generateRecurringTransactions() {
        this.recurringTransactionService.generateRecurringTransactions();
    }
}
