package com.epam.university.java.core.task033;

class LessExceptionImpl extends BaseExceptionImpl implements LessException {
    LessExceptionImpl() {
        super();
    }

    LessExceptionImpl(String message) {
        super(message);
    }

    LessExceptionImpl(String message, Throwable cause) {
        super(message, cause);
    }

    LessExceptionImpl(Throwable cause) {
        super(cause);
    }
}
