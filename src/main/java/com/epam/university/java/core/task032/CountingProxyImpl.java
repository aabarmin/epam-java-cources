package com.epam.university.java.core.task032;

import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

public class CountingProxyImpl implements CountingProxy {
    private final Object object;
    private final Map<String, Integer> countingMap = new HashMap<>();

    public CountingProxyImpl(Object object) {
        this.object = object;
    }

    /**
     * Get amount of method call.
     *
     * @param methodName method name
     * @return amount of call
     */
    @Override
    public int getInvocationsCount(String methodName) {
        return countingMap.getOrDefault(methodName, 0);
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        countingMap.put(
                method.getName(),
                countingMap.getOrDefault(method.getName(), 0) + 1
        );
        return method.invoke(object, args);
    }
}
