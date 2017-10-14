package com.epam.university.java.core.task033;

public class GreaterExceptionImpl extends Exception implements GreaterException {

    public GreaterExceptionImpl(String message, String cause) {
        super(message, new BaseExceptionImpl(cause));
    }
}
