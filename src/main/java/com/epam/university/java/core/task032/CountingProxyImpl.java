package com.epam.university.java.core.task032;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

import static com.epam.university.java.core.Callback.runObject;

public class CountingProxyImpl implements CountingProxy {

    private Object obj;
    private final Map<String, Integer> map = new HashMap<>();


    /**
     * Get instance of reflect.Proxy.
     *
     * @param obj object for which will be created Proxy.
     * @return proxy.
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
        return map.getOrDefault(methodName, 0);
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        map.put(method.getName(),
                map.getOrDefault(method.getName(), 0) + 1);
        return runObject(() -> method.invoke(obj, args));
    }
}
