package com.epam.university.java.core.task012.exceptions;

/**
 * Custom exception for task012.
 */
public final class VertexNotExistsException extends GraphException {

    /**
     * Constructor with one parameter.
     * @param message - message.
     */
    public VertexNotExistsException(final String message) {
        super(message);
    }

    /**
     * Constructor with two parameters.
     * @param message - message.
     * @param cause - cause.
     */
    public VertexNotExistsException(
            final String message, final Throwable cause) {
        super(message, cause);
    }
}
