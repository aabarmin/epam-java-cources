package com.epam.university.java.core.task032;

import com.epam.university.java.core.utils.common.Logger;

/**
 * Class implements Task032.
 */
public class SomeActionExecutorImpl implements SomeActionExecutor {
    private Logger logger = new Logger();

    @Override
    public void doAction() {
        logger.addLoggerLine("action one in progress...",
                false);
    }

    @Override
    public void doAnotherAction() {
        logger.addLoggerLine("another action in progress",
                false);
    }
}