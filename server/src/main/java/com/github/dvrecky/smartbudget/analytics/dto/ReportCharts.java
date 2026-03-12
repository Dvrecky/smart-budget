package com.github.dvrecky.smartbudget.analytics.dto;

public record ReportCharts(
        byte[] balanceHistoryChart,
        byte[] expenseCategoryChart,
        byte[] incomeCategoryChart,
        byte[] cashFlowChart
) {
}
