package com.epam.university.java.core.task032;

import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

public class CountingProxyImpl implements CountingProxy {
    Object obj;
    Map<String, Integer> methodCalls = new HashMap<>();

    /**
     * Returns an instance of a proxy class.
     * @param obj executor object
     * @return a proxy instance with the specified invocation handler of a
     *          proxy class that is defined by the specified class loader
     *          and that implements the specified interfaces
     */
    public Object newInstance(Object obj) {
        this.obj = obj;
        return java.lang.reflect.Proxy.newProxyInstance(
                obj.getClass().getClassLoader(),
                obj.getClass().getInterfaces(),
                this);
    }

    @Override
    public int getInvocationsCount(String methodName) {
        return methodCalls.getOrDefault(methodName, 0);
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        if (!methodCalls.containsKey(method.getName())) {
            methodCalls.put(method.getName(), 1);
        } else {
            methodCalls.replace(method.getName(), methodCalls.get(method.getName()) + 1);

        }

        return method.invoke(obj, args);
    }
}
