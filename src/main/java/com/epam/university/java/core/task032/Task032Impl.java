package com.epam.university.java.core.task032;

/**
 * Implementation class for Task032.
 *
 * @author Sergei Titov
 */
public class Task032Impl implements Task032 {

    /**
     * {@inheritDoc}
     */
    @Override
    public CountingProxy createProxyWrapper() {
        return new CountingProxyImpl();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public SomeActionExecutor createExecutorWithProxy(CountingProxy proxy) {
        return new SomeActionExecutorImpl();
    }
}
