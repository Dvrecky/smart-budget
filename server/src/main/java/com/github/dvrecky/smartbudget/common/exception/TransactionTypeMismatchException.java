package com.github.dvrecky.smartbudget.common.exception;

import com.github.dvrecky.smartbudget.category.domain.CategoryType;
import com.github.dvrecky.smartbudget.transaction_common.domain.TransactionType;

public class TransactionTypeMismatchException extends ApplicationException{

    public TransactionTypeMismatchException(TransactionType transactionType,
                                            CategoryType categoryType,
                                            ErrorCode errorCode) {
        super("Transaction type: " + transactionType.name() + " mismatch category type: " + categoryType.name(), errorCode);
    }
}
