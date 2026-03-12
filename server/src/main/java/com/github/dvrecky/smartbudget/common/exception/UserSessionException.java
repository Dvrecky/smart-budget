package com.github.dvrecky.smartbudget.common.exception;

public class UserSessionException extends AuthenticationException {
    public UserSessionException(String message, ErrorCode errorCode) {
        super(message, errorCode);
    }
}
