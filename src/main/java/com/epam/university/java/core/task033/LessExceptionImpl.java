package com.epam.university.java.core.task033;

public class LessExceptionImpl extends RuntimeException implements LessException {
    public LessExceptionImpl() {
        super();
    }

    public LessExceptionImpl(String message) {
        super(message);
    }

    public LessExceptionImpl(String message, Throwable cause) {
        super(message, cause);
    }

    public LessExceptionImpl(Throwable cause) {
        super(cause);
    }

}