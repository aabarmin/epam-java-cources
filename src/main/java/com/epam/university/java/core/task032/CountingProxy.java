package com.epam.university.java.core.task032;

/**
 * Proxy interface.
 */
public interface CountingProxy {
    /**
     * Get amount of method call.
     * @param methodName method name
     * @return amount of call
     */
    int getInvocationsCount(String methodName);
}
