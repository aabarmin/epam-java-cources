package com.epam.university.java.core.task033;

public class GreaterExceptionImpl extends BaseExceptionImpl implements GreaterException {

    public GreaterExceptionImpl() {
    }

    public GreaterExceptionImpl(String message) {
        super(message);
    }

    public GreaterExceptionImpl(String message, Throwable cause) {
        super(message, cause);
    }

    public GreaterExceptionImpl(Throwable cause) {
        super(cause);
    }

    public GreaterExceptionImpl(String message, Throwable cause,
                                boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}



