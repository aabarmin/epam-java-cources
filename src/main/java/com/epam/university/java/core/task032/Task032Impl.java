package com.epam.university.java.core.task032;

/**
 * Created by Вера on 15.10.2017.
 */
public class Task032Impl implements Task032 {
    @Override
    public CountingProxy createProxyWrapper() {
        return new CountingProxyImpl();
    }

    @Override
    public SomeActionExecutor createExecutorWithProxy(CountingProxy proxy) {
        SomeActionExecutor someActionExecutor = new SomeActionExecutorImpl(proxy);

        return someActionExecutor;
    }
}
