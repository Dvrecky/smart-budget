package com.github.dvrecky.smartbudget.account.domain;

import com.github.dvrecky.smartbudget.common.exception.ErrorCode;
import com.github.dvrecky.smartbudget.common.exception.ValidationException;
import com.fasterxml.jackson.annotation.JsonCreator;

public enum AccountType {
    PERSONAL;

    @JsonCreator
    public static AccountType fromString(String value) {
        if (value == null) {
            return null;
        }
        try {
            return AccountType.valueOf(value.toUpperCase());
        } catch (IllegalArgumentException e) {
            throw new ValidationException("Incorrect type: " + value, ErrorCode.WRONG_TYPE);
        }
    }
}
