package com.github.dvrecky.smartbudget.recurring_transaction.dto;

import com.github.dvrecky.smartbudget.recurring_transaction.domain.UpcomingTransactionsTimeRange;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UpcomingTransactionFilterParams {

    private UpcomingTransactionsTimeRange range = UpcomingTransactionsTimeRange.NEXT_7_DAYS;

    private List<Long> accountIds = new ArrayList<>();

}
