package com.epam.university.java.core.task037;

import java.util.ArrayList;
import java.util.Collection;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Task037Impl implements Task037 {
    @Override
    public Collection<String> switcher(Callable<String> ticker, Callable<String> tacker) {
        ExecutorService executor = Executors.newFixedThreadPool(2);
        Collection<String> result = new ArrayList<>(10);
        try {
            for (int i = 0; i < 5; i++) {
                result.add(executor.submit(ticker).get());
                result.add(executor.submit(tacker).get());
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        executor.shutdown();
        return result;
    }
}