package com.epam.university.java.core.task032;

/**
 * Executor of some action.
 */
public class SomeActionExecutorImpl implements SomeActionExecutor {

    /**
     * Do the action, not important for us.
     */
    @Override
    public void doAction() {
        System.out.println(
            String.format(
                "original executor [id: %d] doAction called",
                System.identityHashCode(this)
            )
        );
    }

    /**
     * Do another action, not important for us.
     */
    @Override
    public void doAnotherAction() {
        System.out.println(
            String.format(
                "original executor [id: %d] doAnotherAction called",
                System.identityHashCode(this)
            )
        );
    }

}
