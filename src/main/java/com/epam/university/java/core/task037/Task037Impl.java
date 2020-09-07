package com.epam.university.java.core.task037;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class Task037Impl implements Task037 {
    @Override
    public Collection<String> switcher(Callable<String> ticker, Callable<String> tacker) {
        if (ticker == null || tacker == null) {
            throw new IllegalArgumentException();
        }

        List<String> resultList = new ArrayList<>();
        List<Callable<String>> tasks = new ArrayList<>();
        int countDown = 5;

        for (int i = 0; i < countDown; i++) {
            tasks.add(ticker);
            tasks.add(tacker);
        }

        ExecutorService service = Executors.newFixedThreadPool(2);

        try {
            List<Future<String>> futures = service.invokeAll(tasks);
            for (Future<String> future : futures) {
                resultList.add(future.get());
            }
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }

        return resultList;
    }
}
