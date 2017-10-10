package com.epam.university.java.core.task032;

/**
 * Reflective proxy.
 */
public interface Task032 {
    /**
     * Create proxy wrapper.
     * @return proxy instance
     */
    CountingProxy createProxyWrapper();

    /**
     * Create action executor with given proxy instance.
     * @param proxy proxy instance
     * @return action executor instance
     */
    SomeActionExecutor createExecutorWithProxy(CountingProxy proxy);
}
