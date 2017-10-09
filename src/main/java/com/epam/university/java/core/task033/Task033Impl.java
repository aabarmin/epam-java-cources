package com.epam.university.java.core.task033;

public class Task033Impl implements Task033 {

    @Override
    public void doSomething(int first, int second) {
        if (first == 0 && second == 0) {
            throw new ArithmeticException("Division by 0");
        }
        throw first > second ? new GreaterExceptionImpl("First > Second", new BaseExceptionImpl())
                : new LessExceptionImpl("Second > First", new BaseExceptionImpl());
    }
}
