package com.github.dvrecky.smartbudget.category.domain;

import com.github.dvrecky.smartbudget.common.exception.ErrorCode;
import com.github.dvrecky.smartbudget.common.exception.ValidationException;
import com.github.dvrecky.smartbudget.transaction_common.domain.TransactionType;
import com.fasterxml.jackson.annotation.JsonCreator;

public enum CategoryType {
    INCOME {
        @Override
        public boolean supports(TransactionType transactionType) {
            return transactionType == TransactionType.INCOME;
        }
    },

    EXPENSE {
        @Override
        public boolean supports(TransactionType transactionType) {
            return transactionType == TransactionType.EXPENSE;
        }
    },

    GENERAL {
        @Override
        public boolean supports(TransactionType transactionType) {
            return true;
        }
    };

    public abstract boolean supports(TransactionType transactionType);

    @JsonCreator
    public CategoryType fromString(String value) {
        if (value == null) {
            return null;
        }
        try {
            return CategoryType.valueOf(value.toUpperCase());
        } catch (IllegalArgumentException e) {
            throw new ValidationException("Incorrect category type: " + value, ErrorCode.WRONG_CATEGORY_TYPE);
        }
    }
}
