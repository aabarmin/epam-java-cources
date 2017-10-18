package com.epam.university.java.core.task033;

/**
 * Created by ilya on 08.10.17.
 */
public class GreaterExceptionImpl extends RuntimeException implements GreaterException {

    public GreaterExceptionImpl(String s, RuntimeException e) {
        super(s, e);
    }
}
