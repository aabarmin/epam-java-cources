package com.epam.university.java.core.task032;

import java.lang.reflect.Proxy;

/**
 * Created by Romin Nuro on 11.09.2020 22:25.
 */
public class Task032Impl implements Task032 {
    private final SomeActionExecutor original = new SomeActionExecutorImpl();

    /**
     * Create proxy wrapper.
     *
     * @return proxy instance
     */
    @Override
    public CountingProxy createProxyWrapper() {
        CountingProxy wrapper = new CountingProxyImpl(original);
        return wrapper;
    }

    /**
     * Create action executor with given proxy instance.
     *
     * @param proxy proxy instance
     * @return action executor instance
     */
    @Override
    public SomeActionExecutor createExecutorWithProxy(CountingProxy proxy) {
        if (proxy == null) {
            throw new IllegalArgumentException();
        }
        SomeActionExecutor executor = (SomeActionExecutor) Proxy.newProxyInstance(
                Task032Impl.class.getClassLoader(),
                new Class[] { SomeActionExecutor.class },
                proxy);
        return executor;
    }
}
