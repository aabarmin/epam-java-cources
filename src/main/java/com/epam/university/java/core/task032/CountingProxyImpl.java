package com.epam.university.java.core.task032;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.UndeclaredThrowableException;
import java.util.HashMap;
import java.util.Map;

public class CountingProxyImpl implements CountingProxy {

    private Object obj;
    private Map<String, Integer> invocations = new HashMap<>();


    /** Better to use static, but not possible cause of interfaces and tests structure
    * http://docs.oracle.com/javase/7/docs/technotes/guides/reflection/proxy.html
    */
    public Object newInstance(Object obj) {

        this.obj = obj;

        return java.lang.reflect.Proxy.newProxyInstance(
                obj.getClass().getClassLoader(),
                obj.getClass().getInterfaces(),
                this);

    }

    /**
     * Processes a method invocation on a proxy instance and returns
     * the result.  This method will be invoked on an invocation handler
     * when a method is invoked on a proxy instance that it is
     * associated with.
     */
    public Object invoke(Object proxy, Method m, Object[] args) throws Throwable  {

        Object result;

        try {
            result = m.invoke(obj, args);
        } catch (InvocationTargetException e) {
            throw e.getTargetException();
        } catch (Exception e) {
            throw new RuntimeException("unexpected invocation exception: "
                    + e.getMessage());
        } finally {
            invocations.put(m.getName(), invocations.getOrDefault(m.getName(), 0) + 1);
        }
        return result;

    }

    /**
     * Get amount of method call.
     *
     * @param methodName method name
     * @return amount of call
     */
    @Override
    public int getInvocationsCount(String methodName) {
        return invocations.getOrDefault(methodName, 0);
    }


}
