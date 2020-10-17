package com.epam.university.java.core.task037;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Task037Impl implements Task037 {
    @Override
    public Collection<String> switcher(Callable<String> ticker,
                                       Callable<String> tacker) {
        if (ticker == null || tacker == null) {
            throw new IllegalArgumentException();
        }
        Collection<String> list = new ArrayList<>();
        ExecutorService executor = Executors.newWorkStealingPool();
        List<Callable<String>> callables = Arrays.asList(
                ticker,
                tacker
        );

        for (int i = 0; i < 5; i++) {
            try {
                executor.invokeAll(callables)
                        .stream()
                        .map(future -> {
                            try {
                                list.add(future.get());
                                return future.get();
                            } catch (Exception e) {
                                throw new IllegalStateException(e);
                            }
                        }).forEach(System.out::println);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        return list;
    }
}
