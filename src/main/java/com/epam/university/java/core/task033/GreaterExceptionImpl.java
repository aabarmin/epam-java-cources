package com.epam.university.java.core.task033;

/**
 * Created by Александр on 09.10.2017.
 * Exception implementation.
 */
public class GreaterExceptionImpl extends RuntimeException
        implements GreaterException, BaseException {
    GreaterExceptionImpl(String message) {
        super(message, new BaseExceptionImpl());
    }
}
