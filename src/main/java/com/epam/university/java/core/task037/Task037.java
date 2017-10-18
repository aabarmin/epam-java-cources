package com.epam.university.java.core.task037;

import java.util.Collection;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;

/**
 * Locks.
 */
public interface Task037 {
    /**
     * Implement wall watches using concurrency.
     * @param ticker produces "tick" string
     * @param tacker produces "tack" string
     * @return collection of tick-tack's
     */
    Collection<String> switcher(Callable<String> ticker,
                                Callable<String> tacker)
        throws ExecutionException, InterruptedException;
}
