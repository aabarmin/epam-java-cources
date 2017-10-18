package com.epam.university.java.core.task033;

/**
 * Implementation class for Task033.
 *
 * @author Sergei Titov
 */
public class Task033Impl implements Task033 {

    /**
     * {@inheritDoc}
     */
    @Override
    public void doSomething(int first, int second) throws Exception  {

        if (first > second) {
            throw new GreaterExceptionImpl("First > Second", "There is no basic message");
        }

        if (first < second) {
            throw new LessExceptionImpl("Second > First", "There is no basic message");
        }

        throw new ArithmeticException();
    }
}
