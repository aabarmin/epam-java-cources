package com.epam.university.java.core.task033;

/**
 * Author Dmitry Novikov 15-Sep-20.
 */
public class LessExceptionImpl extends RuntimeException implements LessException {
    public LessExceptionImpl(String s, Throwable t) {
        super(s, t);
    }
}
