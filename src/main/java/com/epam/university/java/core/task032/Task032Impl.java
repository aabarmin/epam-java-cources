package com.epam.university.java.core.task032;

import java.lang.reflect.Proxy;

/**
 * {@inheritDoc}
 */
public class Task032Impl implements Task032 {
    /**
     * {@inheritDoc}
     */
    @Override
    public CountingProxy createProxyWrapper() {
        return new CountingProxyImpl();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public SomeActionExecutor createExecutorWithProxy(CountingProxy proxy) {
        Object object = Proxy.newProxyInstance(proxy.getClass().getClassLoader(),
                new Class[]{SomeActionExecutor.class},
                new CountingProxyImpl());

        return (SomeActionExecutor) object;
    }
}
