package com.epam.university.java.core.task032;

import com.epam.university.java.core.utils.common.Validator;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * Class implements CountingProxy.
 */
public class CountingProxyImpl implements CountingProxy {
    private SomeActionExecutor someActionExecutor;
    private Map<String, Integer> invocationsCount;

    /**
     * Initialisation of the <code>CountingProxyImpl</code>.
     */
    CountingProxyImpl() {
        invocationsCount = new HashMap<>();
        someActionExecutor = new SomeActionExecutorImpl();
        Arrays.stream(someActionExecutor.getClass().getMethods())
                .parallel()
                .forEach(method -> invocationsCount.put(method.getName(), 0));
    }

    @Override
    public int getInvocationsCount(String methodName) {
        Validator.validateNotNull(methodName,
                Validator.MESSAGE_FOR_SOURCE_IF_NULL);
        return invocationsCount.get(methodName);
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args)
            throws Throwable {
        Validator.validateNotNull(proxy, method,
                Validator.MESSAGE_FOR_FIRST_PARAMETER_IF_NULL,
                Validator.MESSAGE_FOR_SECOND_PARAMETER_IF_NULL);
        String methodName = method.getName();
        invocationsCount.put(methodName, invocationsCount.get(methodName) + 1);
        try {
            return method.invoke(someActionExecutor, args);
        } catch (InvocationTargetException ex) {
            ex.printStackTrace();
        }
        return null;
    }
}