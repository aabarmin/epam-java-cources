package com.epam.university.java.core.task032;

import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

public class CountingProxyImpl implements CountingProxy {
    private final Object target;
    private Map<String, Integer> amountOfInvocations = new HashMap<>();

    public CountingProxyImpl(Object target) {
        this.target = target;
    }

    @Override
    public int getInvocationsCount(String methodName) {
        return amountOfInvocations.get(methodName);
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        String methodName = method.getName();

        amountOfInvocations.merge(methodName,1,Integer::sum);


        return method.invoke(target, args);
    }
}
