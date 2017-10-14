package com.epam.university.java.core.task032;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

/**
 * Implementation class for CountingProxy.
 *
 * @author Sergei Titov
 */
public class CountingProxyImpl implements CountingProxy {

    /**
     * {@inheritDoc}
     */
    @Override
    public int getInvocationsCount(String methodName) {

        Field f = null;
        try {
            f = SomeActionExecutorImpl.class.getField(methodName + "Counter");
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        }

        try {
            return f.getInt(null);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }

        return 0;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        return null;
    }
}
