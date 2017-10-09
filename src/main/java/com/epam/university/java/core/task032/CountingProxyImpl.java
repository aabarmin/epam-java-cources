package com.epam.university.java.core.task032;

import java.lang.reflect.Method;
import java.util.LinkedHashMap;
import java.util.Map;

public class CountingProxyImpl implements CountingProxy {

    private Map<String, Integer> invocationMap = new LinkedHashMap<>();

    @Override
    public int getInvocationsCount(String methodName) {
        return invocationMap.get(methodName);
    }

    @Override
    public Object invoke(Object o, Method method, Object[] objects)  {
        String name = method.getName();
        Integer count = invocationMap.putIfAbsent(name, 1);
        if (count != null) {
            invocationMap.put(name, count + 1);
        }
        return o;
    }
}