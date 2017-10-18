package com.epam.university.java.core.task033;

public class GreaterExceptionImpl extends IllegalArgumentException
        implements GreaterException {

    /**
     * Constructs a new {@code GreaterExceptionImpl} with specified message.
     *
     * @param message message
     */
    public GreaterExceptionImpl(String message) {
        super(message);
    }

    /**
     * Constructs a new {@code GreaterExceptionImpl} with the specified detail
     * message and cause.
     *
     * @param message the detail message
     * @param cause   the cause
     */
    public GreaterExceptionImpl(String message, Throwable cause) {
        super(message, cause);
    }

    /**
     * Constructs a new {@code GreaterExceptionImpl} with the cause.
     *
     * @param cause the cause
     */
    public GreaterExceptionImpl(Throwable cause) {
        super("First > Second", cause);
    }
}