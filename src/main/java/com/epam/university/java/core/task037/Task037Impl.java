package com.epam.university.java.core.task037;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by Александр on 16.10.2017.
 * Locks.
 */
public class Task037Impl implements Task037 {


    /**
     * Implement wall watches using concurrency.
     * @param ticker produces "tick" string
     * @param tacker produces "tack" string
     * @return collection of tick-tack's
     */
    @Override
    public Collection<String> switcher(Callable<String> ticker, Callable<String> tacker) {
        List<String> clock = new ArrayList<>();
        final ExecutorService executorService = Executors.newFixedThreadPool(2);
        try {
            for (int i = 0; i < 5; i++) {
                clock.add(executorService.submit(ticker).get());
                clock.add(executorService.submit(tacker).get());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        executorService.shutdown();
        return clock;
    }

}
