package com.epam.university.java.core.task033;

/**
 * Created by Romin Nuro on 11.09.2020 17:54.
 */
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
            throw new GreaterExceptionImpl("First > Second", new BaseExceptionImpl());
        }
        if (second > first) {
            throw new LessExceptionImpl("Second > First", new BaseExceptionImpl());
        }
        if (second == 0 && first == 0) {
            throw new ArithmeticException();
        }
    }
}
