package com.github.dvrecky.smartbudget.common.exception;

public class ValidationException extends ApplicationException {
    public ValidationException(String message, ErrorCode errorCode) {
        super(message, errorCode);
    }
}
