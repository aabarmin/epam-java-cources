package com.epam.university.java.core.task037;

import java.util.Collection;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * Created by Romin Nuro on 15.09.2020 17:09.
 */
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
        if (ticker == null || tacker == null) {
            throw new IllegalArgumentException();
        }

        List<String> tickTack = new LinkedList<>();
        List<Future<String>> futures;
        List<Callable<String>> tasks = new LinkedList<>();
        ExecutorService executorService = Executors.newFixedThreadPool(2);

        for (int i = 0; i < 5; i++) {
            tasks.add(ticker);
            tasks.add(tacker);
        }

        try {
            futures = executorService.invokeAll(tasks);
            futures.forEach(future -> {
                try {
                    tickTack.add(future.get());
                } catch (InterruptedException | ExecutionException e) {
                    e.printStackTrace();
                }
            });
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            executorService.shutdown();
        }
        return tickTack;
    }
}
