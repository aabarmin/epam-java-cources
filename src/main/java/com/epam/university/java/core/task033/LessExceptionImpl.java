package com.epam.university.java.core.task033;

class LessExceptionImpl extends BaseExceptionImpl implements LessException {
    public LessExceptionImpl() {
        super();
    }

    public LessExceptionImpl(String message) {
        super(message);
    }

    LessExceptionImpl(String message, Throwable cause) {
        super(message, cause);
    }

    public LessExceptionImpl(Throwable cause) {
        super(cause);
    }
}
