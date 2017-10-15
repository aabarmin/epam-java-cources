package com.epam.university.java.core.task033;

/**
 * Created by Вера on 15.10.2017.
 */
public class LessExceptionImpl extends BaseExceptionImpl implements LessException {
    @Override
    public String getMessage() {
        return "Second > First";
    }

    public LessExceptionImpl(Throwable cause) {
        super(cause);
    }
}
