package com.epam.university.java.core.task033;

public class Task033Impl implements Task033 {
    @Override
    public void doSomething(int first, int second) {
        if (first > second) {
            throw new GreaterExceptionImpl(
                    "First > Second",
                    new BaseExceptionImpl("First > Second", new RuntimeException()));
        } else if (second > first) {
            throw new LessExceptionImpl(
                    "Second > First",
                    new BaseExceptionImpl("First > Second", new RuntimeException()));
        } else {
            int num = first / second;
        }
    }
}
