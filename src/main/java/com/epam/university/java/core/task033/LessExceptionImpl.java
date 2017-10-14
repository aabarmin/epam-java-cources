package com.epam.university.java.core.task033;

public class LessExceptionImpl extends Exception implements LessException {

    public LessExceptionImpl(String message, String cause) {
        super(message, new BaseExceptionImpl(cause));
    }
}

