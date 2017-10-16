package com.epam.university.java.core.task032;

public class SomeActionExecutorImpl implements SomeActionExecutor {

    @Override
    public void doAction() {
        int tmp = 0;
        for (int i = 0; i < 100; i++) {
            tmp += i;
        }
    }

    @Override
    public void doAnotherAction() {
        int i = 0;
        int tmp = 0;
        while (i < 100) {
            tmp += i;
            i++;
        }

    }
}
