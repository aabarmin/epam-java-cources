package com.epam.university.java.core.task032;

/**
 * Author Dmitry Novikov 15-Sep-20.
 */
public class SomeActionExecutorImpl implements SomeActionExecutor {

    @Override
    public void doAction() {
        System.out.println("executing doAction()");
    }

    @Override
    public void doAnotherAction() {
        System.out.println("executing doAnotherAction()");
    }
}
