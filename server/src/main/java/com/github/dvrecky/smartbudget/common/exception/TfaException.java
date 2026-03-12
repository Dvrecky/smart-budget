package com.github.dvrecky.smartbudget.common.exception;

public class TfaException extends ApplicationException {
    public TfaException(String message, ErrorCode errorCode) {
        super(message, errorCode);
    }
}
