package com.epam.university.java.core.task032;

import java.lang.reflect.Method;

public class SomeActionExecutorImpl implements SomeActionExecutor {

    private CountingProxy countingProxy;

    public SomeActionExecutorImpl(CountingProxy countingProxy) {
        this.countingProxy = countingProxy;
    }

    @Override
    public void doAction()  {
        try {
            Method method = this.getClass().getDeclaredMethod("doAction");
            this.countingProxy.invoke(this, method, null);
        } catch (Throwable throwable) {
            throwable.printStackTrace();
        }
    }

    @Override
    public void doAnotherAction() {
        try {
            Method method = this.getClass().getDeclaredMethod("doAnotherAction");
            this.countingProxy.invoke(this, method, null);
        } catch (Throwable throwable) {
            throwable.printStackTrace();
        }
    }
}