package com.github.dvrecky.smartbudget.common.exception;

public class StorageException extends ApplicationException {
    public StorageException(String message, ErrorCode errorCode, Throwable cause) {
        super(message, errorCode, cause);
    }

    public StorageException(String message, ErrorCode errorCode) {
        super(message, errorCode);
    }
}
