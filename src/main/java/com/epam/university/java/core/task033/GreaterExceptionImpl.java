package com.epam.university.java.core.task033;

/**
 * Created by Romin Nuro on 11.09.2020 17:53.
 */
public class GreaterExceptionImpl extends RuntimeException implements GreaterException {

    public GreaterExceptionImpl(String message, Throwable cause) {
        super(message, cause);
    }
}
