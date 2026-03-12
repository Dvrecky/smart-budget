package com.github.dvrecky.smartbudget.common.exception;

public class UserStatusException extends ApplicationException {
    public UserStatusException(String message, ErrorCode errorCode) {
        super(message, errorCode);
    }
}