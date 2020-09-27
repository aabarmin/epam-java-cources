package com.epam.university.java.core.task032;

import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

/**
 * Author Dmitry Novikov 15-Sep-20.
 */
public class CountingProxyImpl implements CountingProxy {

    Map<String, Integer> invocations = new HashMap<>();
    private Object object;

    public CountingProxyImpl(Object object) {
        this.object = object;
    }

    @Override
    public int getInvocationsCount(String methodName) {
        return invocations.get(methodName);
    }


    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        String methodName = method.getName();
        invocations.merge(methodName, 1, Integer::sum);
        return method.invoke(object, args);
    }
}
