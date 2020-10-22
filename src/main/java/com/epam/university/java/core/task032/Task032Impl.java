package com.epam.university.java.core.task032;

import java.lang.reflect.Proxy;

public class Task032Impl implements Task032 {
    @Override
    public CountingProxy createProxyWrapper() {

        return new CountingProxyImpl(new SomeActionExecutorImpl());
    }

    @Override
    public SomeActionExecutor createExecutorWithProxy(CountingProxy proxy) {
        if (proxy == null) {
            throw new IllegalArgumentException();
        }
        SomeActionExecutor executorWithProxy = (SomeActionExecutor) Proxy.newProxyInstance(
                SomeActionExecutor.class.getClassLoader(),
                new Class[]{SomeActionExecutor.class},
                proxy
        );
        return executorWithProxy;
    }
}
