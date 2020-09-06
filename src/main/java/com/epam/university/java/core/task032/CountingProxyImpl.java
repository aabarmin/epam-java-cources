package com.epam.university.java.core.task032;

import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.HashMap;
import java.util.Map;

public class CountingProxyImpl implements CountingProxy {
    private Map<String, Integer> map = new HashMap<>();

    private Object someActionExecutor;

    @Override
    public int getInvocationsCount(String methodName) {
        return map.get(methodName);
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        if (map.containsKey(method.getName())) {
            int newVal = map.get(method.getName()) + 1;
            map.put(method.getName(), newVal);
        } else {
            map.put(method.getName(), 1);
        }
        return method.invoke(someActionExecutor, args);
    }

    public SomeActionExecutor setExecutor(Object someActionExecutor) {
        this.someActionExecutor = someActionExecutor;
        return (SomeActionExecutor) Proxy.newProxyInstance(someActionExecutor.getClass().getClassLoader(),
                someActionExecutor.getClass().getInterfaces(), this);
    }
}
