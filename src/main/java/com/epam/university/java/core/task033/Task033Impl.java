package com.epam.university.java.core.task033;

public class Task033Impl implements Task033 {

    @Override
    public void doSomething(int first, int second) {
        throw first == second && second == 0 ? new BaseExceptionImpl("Division by zero")
            : first > second ? new GreaterExceptionImpl(new BaseExceptionImpl())
            : second > first ? new LessExceptionImpl(new BaseExceptionImpl())
            : new BaseExceptionImpl("¯\\_(ツ)_/¯");
    }

}
