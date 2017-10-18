package com.epam.university.java.core.task033;

/**
 * {@inheritDoc}
 */
public class GreaterExceptionImpl extends BaseExceptionImpl implements GreaterException {
    private String message;

    /**
     * Create entity of GreaterException with given message.
     *
     * @param message message
     */
    public GreaterExceptionImpl(String message) {
        this.message = message;
        System.out.println(this instanceof GreaterException);
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
