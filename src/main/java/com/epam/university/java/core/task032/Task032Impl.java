package com.epam.university.java.core.task032;

import java.lang.reflect.Proxy;

public class Task032Impl implements Task032 {

    @Override
    public CountingProxy createProxyWrapper() {
        return new CoutingProxyImpl();
    }

    @Override
    public SomeActionExecutor createExecutorWithProxy(CountingProxy proxy) {
        return (SomeActionExecutor) Proxy.newProxyInstance(
                getClass().getClassLoader(),
                new Class[]{ SomeActionExecutor.class},
                proxy
        );
    }
}
