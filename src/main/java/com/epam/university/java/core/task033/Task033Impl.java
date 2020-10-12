package com.epam.university.java.core.task033;

import com.fasterxml.jackson.databind.ser.Serializers;

public class Task033Impl implements Task033 {
    /**
     * Throws different exceptions.
     * @param first first value
     * @param second second value
     */
    public void doSomething(int first, int second) {
        if (first == 0 && second == 0) {
            throw new ArithmeticException();
        }

        if (first > second) {
            GreaterExceptionImpl greaterException = new GreaterExceptionImpl("First > Second");
            greaterException.initCause(new BaseExceptionImpl());
            throw greaterException;
        }
        if (first < second) {
            LessExceptionImpl lessException = new LessExceptionImpl("Second > First");
            lessException.initCause(new BaseExceptionImpl());
            throw lessException;
        }
    }
}
