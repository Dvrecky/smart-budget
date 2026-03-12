package com.github.dvrecky.smartbudget.common.enums;

import com.github.dvrecky.smartbudget.common.exception.ErrorCode;
import com.github.dvrecky.smartbudget.common.exception.ValidationException;
import com.fasterxml.jackson.annotation.JsonCreator;

public enum SupportedCurrency {
    PLN, USD, GBP, EUR;

    @JsonCreator
    public SupportedCurrency fromString(String value) {
        if (value == null) {
            return null;
        }
        try {
            return SupportedCurrency.valueOf(value.toUpperCase());
        } catch (IllegalArgumentException e) {
            throw new ValidationException("Incorrect currency: " + value, ErrorCode.WRONG_CURRENCY);
        }
    }
}
