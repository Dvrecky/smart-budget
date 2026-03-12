package com.github.dvrecky.smartbudget.analytics.service;

import com.github.dvrecky.smartbudget.analytics.dto.BalanceHistoryPointDto;
import com.github.dvrecky.smartbudget.analytics.dto.CashFlowPointDto;
import com.github.dvrecky.smartbudget.analytics.dto.CategoryBreakdownPointDto;

import java.util.List;

public interface ChartService {
    byte[] generateBalanceChart(List<BalanceHistoryPointDto> data);
    byte[] generateCashFlowChart(List<CashFlowPointDto> data);
    byte[] generateCategorySumChart(List<CategoryBreakdownPointDto> data);
}
