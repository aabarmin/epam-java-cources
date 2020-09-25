package com.epam.university.java.core.task033;

public class Task033Impl implements Task033 {

    @Override
    public void doSomething(int first, int second) throws Exception {
        if (first == 0 && second == 0){
            throw new ArithmeticException();
        }
            if (first > second) {
                Exception e = new GreaterExceptionImpl("First > Second", new BaseExceptionImpl("Some Cause"));
                throw e;
            }
        if (first < second) {
            Exception e = new LessExceptionImpl("Second > First", new BaseExceptionImpl("Some Cause"));
            throw e;
        }
    }
}
