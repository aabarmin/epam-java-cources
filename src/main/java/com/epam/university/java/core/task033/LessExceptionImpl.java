package com.epam.university.java.core.task033;

public class LessExceptionImpl extends BaseExceptionImpl implements LessException {
    public LessExceptionImpl() {
        super();
    }

    public LessExceptionImpl(String message) {
        super(message);
    }

    public LessExceptionImpl(String message, Throwable cause) {
        super(message, cause);
    }
}
