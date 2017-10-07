package com.epam.university.java.core.task033;

class GreaterExceptionImpl extends BaseExceptionImpl implements GreaterException {
    GreaterExceptionImpl() {
        super();
    }

    GreaterExceptionImpl(String message) {
        super(message);
    }

    GreaterExceptionImpl(String message, Throwable cause) {
        super(message, cause);
    }

    GreaterExceptionImpl(Throwable cause) {
        super(cause);
    }
}
