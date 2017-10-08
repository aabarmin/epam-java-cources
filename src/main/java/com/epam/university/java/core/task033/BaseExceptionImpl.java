package com.epam.university.java.core.task033;

class BaseExceptionImpl extends RuntimeException implements BaseException {
    public BaseExceptionImpl() {
        super();
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
}
