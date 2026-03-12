package com.github.dvrecky.smartbudget.common.exception;

public class CategoryChangeNotAllowedException extends ApplicationException{

    public CategoryChangeNotAllowedException(Long transactionId, ErrorCode errorCode) {
        super("Transaction with id: " + transactionId + " is recurring transaction", errorCode);
    }
}
