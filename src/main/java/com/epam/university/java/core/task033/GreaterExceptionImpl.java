package com.epam.university.java.core.task033;

/**
 * Created by Вера on 15.10.2017.
 */
public class GreaterExceptionImpl extends BaseExceptionImpl implements GreaterException {
    @Override
    public String getMessage() {
        return "First > Second";
    }

    public GreaterExceptionImpl(Throwable cause) {
        super(cause);
    }
}
