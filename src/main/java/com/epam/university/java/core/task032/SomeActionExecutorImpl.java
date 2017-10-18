package com.epam.university.java.core.task032;

import java.lang.reflect.Method;

/**
 * Created by Вера on 15.10.2017.
 */
public class SomeActionExecutorImpl implements SomeActionExecutor {
    private CountingProxy original;

    public SomeActionExecutorImpl(CountingProxy original) {
        this.original = original;
    }

    @Override
    public void doAction() {
        //System.out.println("Hello from doAction");

        Class c = this.getClass();
        try {
            @SuppressWarnings("unchecked")
            Method method = c.getDeclaredMethod("doAction");
            this.original.invoke(this, method, null);
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (Throwable throwable) {
            throwable.printStackTrace();
        }
    }

    @Override
    public void doAnotherAction() {
        //System.out.println("Hello from doAnotherAction");

        Class c = this.getClass();
        try {
            @SuppressWarnings("unchecked")
            Method method = c.getDeclaredMethod("doAnotherAction");
            this.original.invoke(this, method, null);
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (Throwable throwable) {
            throwable.printStackTrace();
        }
    }

}
