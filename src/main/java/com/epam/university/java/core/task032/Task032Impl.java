package com.epam.university.java.core.task032;

import com.epam.university.java.core.task031.Task031;

import java.lang.reflect.Proxy;

/**
 * Created by Александр on 09.10.2017.
 * Reflective proxy.
 */
public class Task032Impl implements Task032 {
    /**
     * Create proxy wrapper.
     *
     * @return proxy instance
     */
    @Override
    public CountingProxy createProxyWrapper() {
        return new DefaultCountingProxy();
    }

    /**
     * Create action executor with given proxy instance.
     *
     * @param proxy proxy instance
     * @return action executor instance
     */
    @Override
    public SomeActionExecutor createExecutorWithProxy(CountingProxy proxy) {
        return (SomeActionExecutor) Proxy.newProxyInstance(
                DefaultSomeActionExecutor.class.getClassLoader(),
                DefaultSomeActionExecutor.class.getInterfaces(),
                proxy);
    }
}
