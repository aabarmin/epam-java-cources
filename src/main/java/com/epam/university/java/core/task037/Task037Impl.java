package com.epam.university.java.core.task037;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
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

        List<String> resultStrings = new ArrayList<>();
        List<Callable<String>> tasks = new ArrayList<>();

        for (int i = 0; i < 5; i++) {
            tasks.add(ticker);
            tasks.add(tacker);
        }

        ExecutorService executorService = Executors.newCachedThreadPool();

        try {
            final List<Future<String>> futureList = executorService.invokeAll(tasks);
            for (Future<String> future : futureList) {
                resultStrings.add(future.get());
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            executorService.shutdown();
        }

        return resultStrings;

    }
}
