package com.epam.university.java.core.task037;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.ExecutionException;

public class Task037Impl implements Task037 {
    @Override
    public Collection<String> switcher(Callable<String> ticker, Callable<String> tacker) {
        List<String> result = new ArrayList<>();
        List<Future<String>> futures = new ArrayList<>();

        ExecutorService executor = Executors.newCachedThreadPool();
        for (int i = 0; i < 5; i++) {
            futures.add(executor.submit(ticker));
            futures.add(executor.submit(tacker));
        }
        executor.shutdown();

        for (Future future : futures) {
            try {
                result.add(String.valueOf(future.get()));
            } catch (InterruptedException | ExecutionException e) {
                e.printStackTrace();
            }
        }
        return result;
    }
}