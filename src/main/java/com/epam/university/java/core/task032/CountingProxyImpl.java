package com.epam.university.java.core.task032;

import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by ilya on 08.10.17.
 */
public class CountingProxyImpl implements CountingProxy {

    private Map<String, Integer> invokations = new HashMap<>();

    @Override
    public int getInvocationsCount(String methodName) {
        return invokations.get(methodName);
    }

    @Override
    public Object invoke(Object o, Method method, Object[] objects) throws Throwable {
        if (!invokations.containsKey(method.getName())) {
            invokations.put(method.getName(), 1);
        } else {
            int count = invokations.get(method.getName());
            invokations.put(method.getName(), ++count);
        }
        return o;
    }
}
