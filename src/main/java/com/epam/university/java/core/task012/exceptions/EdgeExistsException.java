package com.epam.university.java.core.task012.exceptions;

/**
 * Custom exception for task012.
 */
public class EdgeExistsException extends GraphException {

    /**
     * Constructor with one parameter.
     * @param message - message.
     */
    public EdgeExistsException(final String message) {
        super(message);
    }

    /**
     * Constructor with two parameters.
     * @param message - message.
     * @param cause - cause.
     */
    public EdgeExistsException(final String message, final Throwable cause) {
        super(message, cause);
    }
}
