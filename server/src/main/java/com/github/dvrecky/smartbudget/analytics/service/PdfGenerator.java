package com.github.dvrecky.smartbudget.analytics.service;

import com.github.dvrecky.smartbudget.analytics.dto.FinancialReportData;
import com.github.dvrecky.smartbudget.analytics.dto.ReportCharts;

public interface PdfGenerator {

    byte[] generateFinancialReportPdf(FinancialReportData data, ReportCharts chartsData);
}
