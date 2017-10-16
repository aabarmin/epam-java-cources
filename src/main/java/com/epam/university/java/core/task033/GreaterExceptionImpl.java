package com.epam.university.java.core.task033;

public class GreaterExceptionImpl extends BaseExceptionImpl implements GreaterException {
    public GreaterExceptionImpl() {
        super();
    }

    public GreaterExceptionImpl(String message) {
        super(message);
    }

    public GreaterExceptionImpl(String message, Throwable cause) {
        super(message, cause);
    }
}
