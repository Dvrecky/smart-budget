package com.github.dvrecky.smartbudget.analytics.events;

public record FinancialReportEvent(
        String userEmail,
        String userName,
        byte[] pdfData
) {
}
