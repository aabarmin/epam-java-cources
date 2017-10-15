package com.epam.university.java.core.task037;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.concurrent.*;

public class Task037Impl implements Task037 {
    @Override
    public Collection<String> switcher(Callable<String> ticker, Callable<String> tacker) {
        List<String> output = new ArrayList<>();
        List<Future<String>> futures;
        List<Callable<String>> actions = new ArrayList<>();
        ExecutorService executor = Executors.newCachedThreadPool();
        for (int i = 0; i < 5; i++) {
            actions.add(ticker);
            actions.add(tacker);
        }
        try {
            futures = executor.invokeAll(actions);
            for (Future<String> future : futures) {
                output.add(future.get());
            }
            executor.shutdown();
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }
        return output;
    }
}
