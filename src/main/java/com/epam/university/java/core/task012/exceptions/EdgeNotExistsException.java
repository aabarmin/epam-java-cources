package com.epam.university.java.core.task012.exceptions;

/**
 * Custom exception for task012.
 */
public final class EdgeNotExistsException extends GraphException {

    /**
     * Constructor with one parameter.
     * @param message - message.
     */
    public EdgeNotExistsException(final String message) {
        super(message);
    }

    /**
     * Constructor with two parameters.
     * @param message - message.
     * @param cause - cause.
     */
    public EdgeNotExistsException(final String message, final Throwable cause) {
        super(message, cause);
    }
}
