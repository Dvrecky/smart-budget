package com.github.dvrecky.smartbudget.analytics.listener;

import com.github.dvrecky.smartbudget.analytics.events.FinancialReportEvent;
import com.github.dvrecky.smartbudget.common.mail.EmailService;
import lombok.RequiredArgsConstructor;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;
import org.springframework.transaction.event.TransactionPhase;
import org.springframework.transaction.event.TransactionalEventListener;

@Component
@RequiredArgsConstructor
public class FinancialReportListener {

    private final EmailService emailService;

    @Async
    @TransactionalEventListener(phase = TransactionPhase.AFTER_COMMIT)
    public void handleFinancialReport(FinancialReportEvent event) {
        emailService.sendFinancialReport(event.userEmail(), event.userName(), event.pdfData());
    }
}
