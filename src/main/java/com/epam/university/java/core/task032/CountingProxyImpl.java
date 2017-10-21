package com.epam.university.java.core.task032;

import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class CountingProxyImpl implements CountingProxy {
    private int invocationsOfDoAction = 0;
    private int invocationsOfDoAnotherAction = 0;
    private Object obj;

    CountingProxyImpl(Object obj) {
        this.obj = obj;
    }

    SomeActionExecutor executor() {
        return (SomeActionExecutor) Proxy.newProxyInstance(
                obj.getClass().getClassLoader(),
                obj.getClass().getInterfaces(),
                this
        );
    }

    @Override
    public int getInvocationsCount(String methodName) {
        if (methodName.equals("doAction")) {
            return invocationsOfDoAction;
        } else {
            return invocationsOfDoAnotherAction;
        }
    }


    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        if (method.getName().equals("doAction")) {
            invocationsOfDoAction++;
            System.out.println("first invoke");
        } else if (method.getName().equals("doAnotherAction")) {
            invocationsOfDoAnotherAction++;
            System.out.println("second invoke");
        }
        return method.invoke(obj, args);
    }
}
