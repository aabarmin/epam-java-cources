package com.epam.university.java.core.task033;

public class LessExceptionImpl extends Exception implements LessException {
    @Override
    public String getMessage() {
        return "Second > First";
    }

    @Override
    public synchronized Throwable getCause() {
        return new BaseExceptionImpl();
    }
}
