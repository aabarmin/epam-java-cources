package com.epam.university.java.core.task032;

/**
 * Implementation class for SomeActionExecutor.
 *
 * @author Sergei Titov
 */
public class SomeActionExecutorImpl implements SomeActionExecutor {

    public static int doActionCounter = 0;
    public static int doAnotherActionCounter = 0;

    /**
     * {@inheritDoc}
     */
    @Override
    public void doAction() {
        doActionCounter++;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void doAnotherAction() {
        doAnotherActionCounter++;
    }
}
