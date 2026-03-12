package com.github.dvrecky.smartbudget.analytics.service;

import java.time.LocalDateTime;

public interface FinancialReportService {

    void generateFinancialReport(Long userId, Long accountId, LocalDateTime from, LocalDateTime to);
}
