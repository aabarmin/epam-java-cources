package com.epam.university.java.core.task032;

import java.lang.reflect.InvocationHandler;

/**
 * Proxy interface.
 */
public interface CountingProxy extends InvocationHandler {
    /**
     * Get amount of method call.
     * @param methodName method name
     * @return amount of call
     */
    int getInvocationsCount(String methodName);
}
