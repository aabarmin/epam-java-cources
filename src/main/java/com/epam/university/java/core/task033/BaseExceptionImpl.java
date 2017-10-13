package com.epam.university.java.core.task033;

public class BaseExceptionImpl extends ArithmeticException implements BaseException {

    public BaseExceptionImpl() {
        super();
    }

    public BaseExceptionImpl(String s) {
        super(s);
    }
}
