package com.epam.university.java.core.task033;

import com.epam.university.java.core.task031.Task031;

/**
 * Created by Александр on 09.10.2017.
 * Exceptions.
 */
public class Task033Impl implements Task033 {
    /**
     * Throws different exceptions.
     *
     * @param first  first value
     * @param second second value
     */
    @Override
    public void doSomething(int first, int second){
        if ((first == 0) && (second == 0)) {
            throw new ArithmeticException();
        }
        if (first > second) {
            throw new GreaterExceptionImpl("First > Second");
        } else {
            throw new LessExceptionImpl("Second > First");
        }

    }
}
