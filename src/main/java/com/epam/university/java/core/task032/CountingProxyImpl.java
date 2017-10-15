package com.epam.university.java.core.task032;

import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Вера on 15.10.2017.
 */
public class CountingProxyImpl implements CountingProxy {
    private Map<String, Integer> count = new HashMap<>();

    @Override
    public int getInvocationsCount(String methodName) {
        return count.get(methodName);
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {

        if (!count.containsKey(method.getName())) {
            count.put(method.getName(), 1);
        } else {
            int count = this.count.get(method.getName());
            this.count.put(method.getName(), ++count);
        }

        return null;
    }
}
