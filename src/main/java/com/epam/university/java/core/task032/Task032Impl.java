package com.epam.university.java.core.task032;

import com.epam.university.java.core.utils.common.Validator;

import java.lang.reflect.Proxy;

/**
 * Class implements <code>Task032</code> interface.
 */
public class Task032Impl implements Task032 {
    @Override
    public CountingProxy createProxyWrapper() {
        return new CountingProxyImpl();
    }

    @Override
    public SomeActionExecutor createExecutorWithProxy(CountingProxy proxy) {
        Validator.validateNotNull(proxy, Validator.MESSAGE_FOR_SOURCE_IF_NULL);
        SomeActionExecutor someActionExecutor = new SomeActionExecutorImpl();
        return (SomeActionExecutor) Proxy.newProxyInstance(
                someActionExecutor.getClass().getClassLoader(),
                someActionExecutor.getClass().getInterfaces(),
                proxy);
    }
}