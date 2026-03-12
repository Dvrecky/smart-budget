package com.github.dvrecky.smartbudget.common.exception;

public abstract class AuthenticationException extends ApplicationException {

    public AuthenticationException(String message, ErrorCode errorCode) {
        super(message, errorCode);
    }

}
