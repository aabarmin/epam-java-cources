package com.epam.university.java.core.task032;

import java.lang.reflect.Method;
import java.util.stream.Stream;

/**
 * Created by ilya on 08.10.17.
 */
public class SomeActionExecutorImpl implements SomeActionExecutor {

    private CountingProxy countingProxy;

    public SomeActionExecutorImpl(CountingProxy countingProxy) {
        this.countingProxy = countingProxy;
    }

    @Override
    public void doAction() {
        //do something
        Class c = this.getClass();
        try {
            Method method = c.getDeclaredMethod("doAction");
            this.countingProxy.invoke(this, method, null);
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (Throwable throwable) {
            throwable.printStackTrace();
        }
    }

    @Override
    public void doAnotherAction() {
        //do something else
        Class c = this.getClass();
        try {
            Method method = c.getDeclaredMethod("doAnotherAction");
            this.countingProxy.invoke(this, method, null);
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (Throwable throwable) {
            throwable.printStackTrace();
        }
    }
}
