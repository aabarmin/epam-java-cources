package com.epam.university.java.core.task033;

/**
 * Created by Вера on 15.10.2017.
 */
public class Task033Impl implements Task033 {


    @Override
    public void doSomething(int first, int second) {
        if (first > second) {
            throw new GreaterExceptionImpl(new BaseExceptionImpl(new Throwable("First > Second")));
        } else if (first < second) {
            throw new LessExceptionImpl(new BaseExceptionImpl(new Throwable("Second > First")));
        } else {
            int a = first / second;
        }
    }
}