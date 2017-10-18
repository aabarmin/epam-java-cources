package com.epam.university.java.core.task033;

public class BaseExceptionImpl extends ArithmeticException implements
        BaseException {

    /**
     * Constructs a new {@code BaseExceptionImpl} with no detail message.
     */
    public BaseExceptionImpl() {
        super();
    }

    /**
     * Constructs a new {@code BaseExceptionImpl} with specified message.
     *
     * @param message message
     */
    public BaseExceptionImpl(String message) {
        super(message);
    }
}