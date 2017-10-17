package com.epam.university.java.core.task033;

public class LessExceptionImpl extends IllegalArgumentException
        implements LessException {

    /**
     * Constructs a new {@code LessExceptionImpl} with specified message.
     *
     * @param message message
     */
    public LessExceptionImpl(String message) {
        super(message);
    }

    /**
     * Constructs a new {@code LessExceptionImpl} with the specified detail
     * message and cause.
     *
     * @param message the detail message
     * @param cause   the cause
     */
    public LessExceptionImpl(String message, Throwable cause) {
        super(message, cause);
    }

    /**
     * Constructs a new {@code LessExceptionImpl} with the cause.
     *
     * @param cause the cause
     */
    public LessExceptionImpl(Throwable cause) {
        super("Second > First", cause);
    }
}