package com.epam.university.java.core.task033;

public class BaseExceptionImpl extends Exception implements BaseException {
    public BaseExceptionImpl() {
    }

    public BaseExceptionImpl(String message) {
        super(message);
    }

    public BaseExceptionImpl(String message, Throwable cause) {
        super(message, cause);
    }

    public BaseExceptionImpl(Throwable cause) {
        super(cause);
    }

    public BaseExceptionImpl(String message, Throwable cause,
                             boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
