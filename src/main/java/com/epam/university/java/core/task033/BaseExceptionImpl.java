package com.epam.university.java.core.task033;



public class BaseExceptionImpl extends  Exception implements BaseException  {
    public BaseExceptionImpl() {
    }

    public BaseExceptionImpl(String message) {
        super(message);
    }

    public BaseExceptionImpl(String message, Throwable cause) {
        super(message, cause);
    }

}
