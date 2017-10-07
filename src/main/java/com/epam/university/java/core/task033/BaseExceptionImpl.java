package com.epam.university.java.core.task033;

public class BaseExceptionImpl extends RuntimeException implements BaseException {

    /**
     * Constructs a new BaseExceptionImpl exception with the specified detail message.
     */
    public BaseExceptionImpl(String message) {
        super(message);
    }

    /**
     * Constructs a new BaseExceptionImpl exception with the specified detail message and
     * cause.
     */
    public BaseExceptionImpl(String message, Throwable cause) {
        super(message, cause);
    }

}
