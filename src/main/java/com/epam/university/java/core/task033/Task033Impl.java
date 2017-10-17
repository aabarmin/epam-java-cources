package com.epam.university.java.core.task033;

/**
 * Class implements <code>Task033</code> interface.
 */
public class Task033Impl implements Task033 {
    @Override
    public void doSomething(int first, int second) {
        if (first < second) {
            throw new LessExceptionImpl("Second > First", new
                    BaseExceptionImpl());
        } else if (first == 0 & second == 0) {
            throw new BaseExceptionImpl();
        } else if (first > second) {
            throw new GreaterExceptionImpl("First > Second",
                    new BaseExceptionImpl());
        }
    }
}