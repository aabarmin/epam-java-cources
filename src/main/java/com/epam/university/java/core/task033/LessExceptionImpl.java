package com.epam.university.java.core.task033;

public class LessExceptionImpl extends BaseExceptionImpl implements LessException {
    public LessExceptionImpl() {
    }

    public LessExceptionImpl(String message) {
        super(message);
    }

    public LessExceptionImpl(String message, Throwable cause) {
        super(message, cause);
    }

    public LessExceptionImpl(Throwable cause) {
        super(cause);
    }

    public LessExceptionImpl(String message, Throwable cause,
                             boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
