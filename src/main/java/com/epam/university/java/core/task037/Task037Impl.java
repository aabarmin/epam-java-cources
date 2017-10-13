package com.epam.university.java.core.task037;

import java.util.Collection;
import java.util.LinkedList;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class Task037Impl implements Task037 {
    /**
     * Implement wall watches using concurrency.
     *
     * @param ticker produces "tick" string
     * @param tacker produces "tack" string
     * @return collection of tick-tack's
     */
    @Override
    public Collection<String> switcher(Callable<String> ticker, Callable<String> tacker) {
        // how much "tick-tack" do we need
        int secondsToCount = 5;
        
        Collection<String> watches = new LinkedList<>();
        Collection<Future<String>> futures = new LinkedList<>();

        //executor to pass "tick tack" pair 
        ExecutorService executor = Executors.newFixedThreadPool(2);

        for (int i = 0; i < secondsToCount; i++) {
            futures.add(executor.submit(ticker));
            futures.add(executor.submit(tacker));
        }

        executor.shutdown();

        for (Future future : futures) {
            try {
                watches.add((String) future.get());
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }

        return watches;
    }
}
