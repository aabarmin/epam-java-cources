package com.epam.university.java.core.task033;

/**
 * Created by ilya on 08.10.17.
 */
public class LessExceptionImpl extends RuntimeException implements LessException {

    public LessExceptionImpl(String s, RuntimeException e) {
        super(s, e);
    }
}
