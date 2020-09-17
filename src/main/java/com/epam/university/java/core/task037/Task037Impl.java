package com.epam.university.java.core.task037;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * Author Dmitry Novikov 17-Sep-20.
 */
public class Task037Impl implements Task037 {
    ExecutorService executor =
            Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors());
    List<String> result = new ArrayList<>();

    @Override
    public Collection<String> switcher(Callable<String> ticker, Callable<String> tacker) {
        if (ticker == null || tacker == null) {
            throw new IllegalArgumentException();
        }
        for (int i = 0; i < 5; i++) {
            Future<String> futureTicker = executor.submit(ticker);
            Future<String> futureTacker = executor.submit(tacker);
            try {
                result.add(futureTicker.get());
                result.add(futureTacker.get());
            } catch (InterruptedException | ExecutionException e) {
                e.printStackTrace();
            }
        }
        executor.shutdown();

        return result;
    }
}
