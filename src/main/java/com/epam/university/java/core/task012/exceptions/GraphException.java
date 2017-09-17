package com.epam.university.java.core.task012.exceptions;

/**
 * Custom exception for task012.
 */
public class GraphException extends RuntimeException {

    /**
     * Constructor with one parameter.
     * @param message - message.
     */
    public GraphException(final String message) {
        super(message);
    }

    /**
     * Constructor with two parameters.
     * @param message - message.
     * @param cause - cause.
     */
    public GraphException(final String message, final Throwable cause) {
        super(message, cause);
    }
}
