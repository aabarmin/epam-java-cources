package com.epam.university.java.core.task032;

import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

public class CoutingProxyImpl implements CountingProxy, SomeActionExecutor {

    Map<String, Integer> methodCount;

    public CoutingProxyImpl() {
        methodCount = new HashMap<>();
    }

    @Override
    public int getInvocationsCount(String methodName) {
        return methodCount.get(methodName);
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {

        if (!methodCount.containsKey(method.getName())) {
            methodCount.put(method.getName(), 1);
        } else {
            methodCount.put(method.getName(), methodCount.get(method.getName()) + 1);
        }


        return method.invoke(this, args);
    }

    @Override
    public void doAction() {
        System.out.println("Action from proxy");
    }

    @Override
    public void doAnotherAction() {
        System.out.println("Another action from proxy");
    }
}
