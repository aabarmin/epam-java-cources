package com.epam.university.java.core.task033;

public class BaseExceptionImpl extends Throwable implements BaseException {


    public BaseExceptionImpl(String someCause) {
        super(someCause);
    }
}
