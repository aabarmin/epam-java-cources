package com.epam.university.java.core.task033;

public class Task033Impl implements Task033 {
    @Override
    public void doSomething(int first, int second) throws GreaterExceptionImpl, LessExceptionImpl {
        if (first > second) {
            throw new GreaterExceptionImpl();
        } else  if (first < second) {
            throw new LessExceptionImpl();
        }
        throw new ArithmeticException();
    }
}
