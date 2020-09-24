package com.epam.university.java.core.task033;

public class GreaterExceptionImpl extends Exception implements GreaterException {

    public GreaterExceptionImpl(String s, Throwable throwable) {
        super(s, throwable);
    }
}
