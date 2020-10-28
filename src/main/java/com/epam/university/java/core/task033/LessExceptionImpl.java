package com.epam.university.java.core.task033;

public class LessExceptionImpl extends Exception implements LessException {

    public LessExceptionImpl(String s, Throwable throwable) {
        super(s, throwable);
    }
}
