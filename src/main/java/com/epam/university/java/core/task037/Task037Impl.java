package com.epam.university.java.core.task037;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.ExecutionException;


/**
 * Created by Daniil Smirnov on 15.10.2017.
 * All copy registered MF.
 */
public class Task037Impl implements Task037 {

    @Override
    public Collection<String> switcher(Callable<String> ticker, Callable<String> tacker) {
        final List<String> result = new ArrayList<>();
        Collection<Future<String>> futures = new ArrayList<>();
        int count = 5;
        ExecutorService executorService = Executors.newFixedThreadPool(2);

        for (int i = 0; i < count; i++) {
            futures.add(executorService.submit(ticker));
            futures.add(executorService.submit(tacker));
        }

        executorService.shutdown();

        futures.forEach(s -> {
            try {
                result.add(s.get());
            } catch (InterruptedException | ExecutionException e) {
                e.printStackTrace();
            }
        });

        return result;
    }
}
