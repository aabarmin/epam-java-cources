package com.epam.university.java.core.task033;

class BaseExceptionImpl extends RuntimeException implements BaseException {
    BaseExceptionImpl() {
        super();
    }
    
    BaseExceptionImpl(String message) {
        super(message);
    }
    
    BaseExceptionImpl(String message, Throwable cause) {
        super(message, cause);
    }
    
    BaseExceptionImpl(Throwable cause) {
        super(cause);
    }
}
