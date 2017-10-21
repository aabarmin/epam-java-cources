package com.epam.university.java.core.task032;

public class SomeActionExecutorImpl implements SomeActionExecutor {
    @Override
    public void doAction() {
        System.out.println("first");
    }

    @Override
    public void doAnotherAction() {
        System.out.println("second");
    }
}
