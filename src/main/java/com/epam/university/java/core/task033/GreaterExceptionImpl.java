package com.epam.university.java.core.task033;

public class GreaterExceptionImpl extends IllegalArgumentException implements GreaterException {

    public GreaterExceptionImpl(String s) {
        super(s);
    }

    public GreaterExceptionImpl(String message, Throwable cause) {
        super(message, cause);
    }

    public GreaterExceptionImpl(Throwable cause) {
        super("First > Second", cause);
    }

}
