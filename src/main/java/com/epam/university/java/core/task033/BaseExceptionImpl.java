package com.epam.university.java.core.task033;

public class BaseExceptionImpl extends RuntimeException implements BaseException {

    /**
     * Constructor without parameters.
     */
    public BaseExceptionImpl() {
        super();
    }

    /**
     * Constructor.
     * @param message information about exception
     */
    public BaseExceptionImpl(String message) {
        super(message);
    }

    /**
     * Constructor.
     * @param message information about exception
     * @param throwable exception
     */
    public BaseExceptionImpl(String message, Throwable throwable) {
        super(message, throwable);
    }

}