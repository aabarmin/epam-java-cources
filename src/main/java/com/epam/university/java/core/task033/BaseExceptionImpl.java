package com.epam.university.java.core.task033;

/**
 * Implementation class for Task033.
 *
 * @author Sergei Titov
 */
public class BaseExceptionImpl extends Exception implements BaseException {

    public BaseExceptionImpl(String cause) {
        super("", new Throwable(cause));
    }
}
