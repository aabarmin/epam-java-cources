package com.epam.university.java.core.task033;

/**
 * {@inheritDoc}
 */
public class LessExceptionImpl extends BaseExceptionImpl implements LessException {
    private String message;

    /**
     * @param message
     */
    public LessExceptionImpl(String message) {
        this.message = message;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String getMessage() {
        return message;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Throwable getCause() {
        return new BaseExceptionImpl();
    }
}
