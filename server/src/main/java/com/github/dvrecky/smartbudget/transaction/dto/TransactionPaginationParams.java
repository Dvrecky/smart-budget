package com.github.dvrecky.smartbudget.transaction.dto;

import com.github.dvrecky.smartbudget.transaction.domain.SortDirection;
import com.github.dvrecky.smartbudget.transaction.domain.SortedBy;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter@Setter
@AllArgsConstructor
@NoArgsConstructor
public class TransactionPaginationParams {

    @Min(value = 1, message = "Indexing of pages begins with 1")
    private int page = 1;

    @Min(value = 1, message = "Page limit value must be a positive value")
    @Max(value = 20, message = "Page limit value must not exceed 20")
    private int limit = 8;

    private SortedBy sortedBy = SortedBy.DATE;
    private SortDirection sortDirection = SortDirection.DESC;
}
