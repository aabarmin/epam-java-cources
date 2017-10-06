package com.epam.university.java.core.task033;

public class LessExceptionImpl extends IllegalArgumentException implements LessException {

    public LessExceptionImpl(String s) {
        super(s);
    }

    public LessExceptionImpl(String message, Throwable cause) {
        super(message, cause);
    }

    public LessExceptionImpl(Throwable cause) {
        super("Second > First", cause);
    }

}
