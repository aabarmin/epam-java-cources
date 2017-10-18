package com.epam.university.java.core.task033;

/**
 * Created by ilya on 08.10.17.
 */
public class Task033Impl implements Task033 {

    @Override
    public void doSomething(int first, int second) {
        if (first > second) {
            throw new GreaterExceptionImpl("First > Second", new BaseExceptionImpl());
        } else if (first < second) {
            throw new LessExceptionImpl("Second > First", new BaseExceptionImpl());
        } else {
            final int i = first / second;
        }
    }
}
