package com.github.dvrecky.smartbudget.common.exception;

public class UserNotAllowedToLoginException extends AuthenticationException {
    public UserNotAllowedToLoginException(String message, ErrorCode errorCode) {
        super(message, errorCode);
    }
}
