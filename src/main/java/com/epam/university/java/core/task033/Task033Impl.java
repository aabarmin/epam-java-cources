package com.epam.university.java.core.task033;

public class Task033Impl implements Task033 {
    /**
     * Throws different exceptions.
     *
     * @param first  first value
     * @param second second value
     */
    @Override
    public void doSomething(int first, int second) {

        if (first > second) {
            throw new GreaterExceptionImpl("First > Second", new BaseExceptionImpl("x"));
        }

        if (second > first) {
            throw new GreaterExceptionImpl("Second > First", new BaseExceptionImpl("x"));
        }

        throw new ArithmeticException();

    }
}
