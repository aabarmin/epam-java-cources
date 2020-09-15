package com.epam.university.java.core.task032;

import java.lang.reflect.Proxy;

/**
 * Author Dmitry Novikov 15-Sep-20.
 */
public class Task032Impl implements Task032 {
    private SomeActionExecutor original = new SomeActionExecutorImpl();

    @Override
    public CountingProxy createProxyWrapper() {
        CountingProxy wrapper = new CountingProxyImpl(original);
        return wrapper;
    }

    @Override
    public SomeActionExecutor createExecutorWithProxy(CountingProxy proxy) {
        if (proxy == null) {
            throw new IllegalArgumentException();
        }

        SomeActionExecutor executor = (SomeActionExecutor) Proxy.newProxyInstance(
                Task032Impl.class.getClassLoader(),
                new Class[]{SomeActionExecutor.class},
                proxy);
        return executor;
    }
}
