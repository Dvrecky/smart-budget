package com.github.dvrecky.smartbudget.notification.listener;

import com.github.dvrecky.smartbudget.notification.domain.NotificationType;
import com.github.dvrecky.smartbudget.notification.service.NotificationService;
import com.github.dvrecky.smartbudget.transaction.events.BudgetExceededEvent;
import lombok.RequiredArgsConstructor;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;
import org.springframework.transaction.event.TransactionPhase;
import org.springframework.transaction.event.TransactionalEventListener;

@Component
@RequiredArgsConstructor
public class BudgetAlertListener {

    private final NotificationService notificationService;

    @Async
    @TransactionalEventListener(phase = TransactionPhase.AFTER_COMMIT)
    public void handleBudgetExceed(BudgetExceededEvent event) {
        String title = null;
        String message = null;
        String targetUrl = "/app/accounts/" + event.accountId();

        if (event.type() ==  NotificationType.WARNING) {
            title = "Budget warning";
            message = String.format(
                    "You are approaching your limit on account ‘%s’. %s of %s has already been spent.",
                    event.accountName(),
                    event.currentUsage(),
                    event.budgetLimit()
            );
        }
        if (event.type() == NotificationType.ERROR) {
            title = "The budget has been exceeded!";
            message = String.format(
                    "Expenses in the account '%s' have exceeded the set budget of %s. Current balance: %s.",
                    event.accountName(),
                    event.budgetLimit(),
                    event.currentUsage()
            );
        }

        notificationService.createAndSend(event.userId(), title, message, event.type(), targetUrl);
    }
}
