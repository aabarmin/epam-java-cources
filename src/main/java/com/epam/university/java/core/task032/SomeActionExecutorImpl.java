package com.epam.university.java.core.task032;

public class SomeActionExecutorImpl implements SomeActionExecutor {

    public SomeActionExecutor createExecutorWithProxy(CountingProxy proxy) {
        return (SomeActionExecutor)
                ((CountingProxyImpl) proxy).newInstance(new SomeActionExecutorImpl());
    }

    @Override
    public void doAction() {
        System.out.println("doing not important action");
    }

    @Override
    public void doAnotherAction() {
        System.out.println("doing another not important action");
    }
}
