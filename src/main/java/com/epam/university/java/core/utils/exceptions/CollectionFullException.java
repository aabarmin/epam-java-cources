package com.epam.university.java.core.utils.exceptions;

/**
 * Throws unchecked exception that can be thrown during the normal
 * operation of the Java Virtual Machine if collection if full.
 */
public class CollectionFullException extends RuntimeException {

    /**
     * Constructs a new CollectionFullException exception with the specified
     * detail message.
     *
     * @param message the detail message.
     */
    public CollectionFullException(String message) {
        super(message);
    }
}
