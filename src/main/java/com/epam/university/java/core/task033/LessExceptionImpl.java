package com.epam.university.java.core.task033;

/**
 * Created by Александр on 09.10.2017.
 * Less exception.
 */
public class LessExceptionImpl extends RuntimeException implements LessException, BaseException {
    LessExceptionImpl(String message){
        super(message, new BaseExceptionImpl());
    }
}
