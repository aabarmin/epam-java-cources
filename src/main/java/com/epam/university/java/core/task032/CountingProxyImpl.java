package com.epam.university.java.core.task032;

import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.HashMap;
import java.util.Map;

public class CountingProxyImpl implements CountingProxy {
    private Map<String, Integer> count = new HashMap<>();
    private Object executor;

    /**
     *  Binding executor to proxy.
     * @param executor executor
     * @return executor
     */
    public SomeActionExecutor setExecutor(Object executor) {
        this.executor = executor;
        return (SomeActionExecutor) Proxy.newProxyInstance(
                executor.getClass().getClassLoader(),
                executor.getClass().getInterfaces(),
                this
        );
    }

    @Override
    public int getInvocationsCount(String methodName) {
        return count.get(methodName);
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        count.put(method.getName(), count.getOrDefault(method.getName(), 0) + 1);
        return method.invoke(executor, args);
    }
}
