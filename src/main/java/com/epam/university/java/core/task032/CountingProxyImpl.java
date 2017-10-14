package com.epam.university.java.core.task032;

import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

/**
 * {@inheritDoc}
 */
public class CountingProxyImpl implements CountingProxy {
    private static Map<String, Integer> map = new HashMap<>();

    /**
     * {@inheritDoc}
     */
    @Override
    public int getInvocationsCount(String methodName) {
        return map.get(methodName);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        String methodName = method.getName();
        map.merge(methodName, 1, (a, b) -> a + 1);
        return null;
    }
}
