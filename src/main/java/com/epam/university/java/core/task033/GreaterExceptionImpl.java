package com.epam.university.java.core.task033;

/**
 * Author Dmitry Novikov 15-Sep-20.
 */
public class GreaterExceptionImpl extends RuntimeException implements GreaterException {
    public GreaterExceptionImpl(String s, Throwable t) {
        super(s, t);
    }

}
