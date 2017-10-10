package com.epam.university.java.core.task033;

public class GreaterExceptionImpl extends BaseExceptionImpl implements GreaterException {

    /**
     * Constructor.
     * @param message information about exception
     * @param throwable exception
     */
    public GreaterExceptionImpl(String message, Throwable throwable) {
        super(message, throwable);
    }

}
