package com.epam.university.java.core.task032;

import java.lang.reflect.Method;
import java.util.HashMap;

public class CountingProxyImpl implements CountingProxy {
    HashMap<String, Integer> mapOfMethods = new HashMap<>();

    /**
     * CountingProxyImpl class constructor.
     *
     * @param target target object.
     */
    public CountingProxyImpl(Object target) {
        Method[] declaredMethods = target.getClass().getDeclaredMethods();
        for (Method m :
                declaredMethods) {
            mapOfMethods.put(m.getName(), 0);
        }
    }

    @Override
    public int getInvocationsCount(String methodName) {
        if (mapOfMethods.containsKey(methodName)) {
            return mapOfMethods.get(methodName);
        }
        return 0;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        String methodName = method.getName();
        if (mapOfMethods.containsKey(methodName)) {
            mapOfMethods.put(methodName, mapOfMethods.get(methodName) + 1);
        }
        return proxy;
    }
}
