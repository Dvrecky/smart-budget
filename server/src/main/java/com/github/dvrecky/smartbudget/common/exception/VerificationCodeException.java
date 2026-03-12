package com.github.dvrecky.smartbudget.common.exception;

public class VerificationCodeException extends AuthenticationException {
    public VerificationCodeException(String message, ErrorCode errorCode) {
        super(message, errorCode);
    }
}
