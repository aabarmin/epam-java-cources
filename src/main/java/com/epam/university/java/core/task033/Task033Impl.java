package com.epam.university.java.core.task033;

public class Task033Impl implements Task033 {
    @Override
    public void doSomething(int first, int second) throws GreaterExceptionImpl, LessExceptionImpl {
        if (first > second) {
            throw new GreaterExceptionImpl("First > Second", new BaseExceptionImpl());
        }
        if (first < second) {
            throw new LessExceptionImpl("Second > First", new BaseExceptionImpl());
        }
        throw new ArithmeticException();
    }
}
