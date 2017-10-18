package com.epam.university.java.core.task033;

/**
 * {@inheritDoc}
 */
public class Task033Impl implements Task033 {
    /**
     * {@inheritDoc}
     */
    @Override
    public void doSomething(int first, int second) {
        if (first == 0 && second == 0) {
            int a = first / second;
        }
        if (first > second) {
            throw new GreaterExceptionImpl("First > Second");
        } else if (first < second) {
            throw new LessExceptionImpl("Second > First");
        }
    }
}
