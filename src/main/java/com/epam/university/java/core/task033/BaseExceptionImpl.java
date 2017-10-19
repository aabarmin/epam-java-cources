package com.epam.university.java.core.task033;

/**
 * Created by Вера on 15.10.2017.
 */
public class BaseExceptionImpl extends RuntimeException implements BaseException {

    public BaseExceptionImpl(Throwable cause) {
        super(cause);
    }
}
