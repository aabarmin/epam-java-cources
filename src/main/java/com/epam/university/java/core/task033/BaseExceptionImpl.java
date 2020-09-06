package com.epam.university.java.core.task033;

public class BaseExceptionImpl extends RuntimeException implements BaseException {

    public BaseExceptionImpl(String message, Throwable cause) {
        super(message, cause);
    }
}
