package com.epam.university.java.core.task032;

import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

public class CountingProxyImpl implements CountingProxy {
    private Map<String, Integer> invocations = new HashMap<>();

    @Override
    public int getInvocationsCount(String methodName) {
        return invocations.get(methodName);
    }

    @Override
    public Object invoke(Object obj, Method method, Object[] args) {
        String name = method.getName();
        Integer count = invocations.putIfAbsent(name, 1);
        if (count != null) {
            invocations.put(name, ++count);
        }
        return obj;
    }
}