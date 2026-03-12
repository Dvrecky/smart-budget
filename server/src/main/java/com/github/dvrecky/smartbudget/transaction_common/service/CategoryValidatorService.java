package com.github.dvrecky.smartbudget.transaction_common.service;

import com.github.dvrecky.smartbudget.category.domain.CategoryType;
import com.github.dvrecky.smartbudget.common.exception.ErrorCode;
import com.github.dvrecky.smartbudget.common.exception.TransactionTypeMismatchException;
import com.github.dvrecky.smartbudget.transaction_common.domain.TransactionType;
import org.springframework.stereotype.Service;

@Service
public class CategoryValidatorService {

    public void validateCategoryType(CategoryType categoryType, TransactionType transactionType) {
        if (!categoryType.supports(transactionType)) {
            throw new TransactionTypeMismatchException(transactionType, categoryType, ErrorCode.TRANSACTION_TYPE_MISMATCH);
        }
    }
}
