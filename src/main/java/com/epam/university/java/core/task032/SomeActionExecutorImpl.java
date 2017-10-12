package com.epam.university.java.core.task032;

import java.lang.reflect.Method;

public class SomeActionExecutorImpl implements SomeActionExecutor {
    private CountingProxy proxy;

    public SomeActionExecutorImpl(CountingProxy proxy) {
        this.proxy = proxy;
    }

    @Override
    public void doAction() {
        try {
            Method method = this.getClass().getDeclaredMethod("doAction");
            this.proxy.invoke(this, method, null);
        } catch (Throwable throwable) {
            throwable.printStackTrace();
        }
    }

    @Override
    public void doAnotherAction() {
        try {
            Method method = this.getClass().getDeclaredMethod("doAnotherAction");
            this.proxy.invoke(this, method, null);
        } catch (Throwable throwable) {
            throwable.printStackTrace();
        }
    }
}