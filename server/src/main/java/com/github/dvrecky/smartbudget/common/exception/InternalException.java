package com.github.dvrecky.smartbudget.common.exception;

public class InternalException extends ApplicationException {
    public InternalException(String message, Throwable cause) {
        super(message, ErrorCode.INTERNAL_EXCEPTION, cause);
    }

    public InternalException(String message) {
        super(message, ErrorCode.INTERNAL_EXCEPTION);
    }
}
