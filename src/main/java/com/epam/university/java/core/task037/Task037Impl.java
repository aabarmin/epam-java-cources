package com.epam.university.java.core.task037;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

import static com.epam.university.java.core.Callback.runObject;
import static com.epam.university.java.core.Callback.runVoid;

public class Task037Impl implements Task037 {
    @Override
    public Collection<String> switcher(Callable<String> ticker, Callable<String> tacker) {
        final int secondsToCount = 5;
        final ExecutorService executorService = Executors.newFixedThreadPool(2);
        final Collection<String> watches = new ArrayList<>();
        final List<Future<String>> list = new ArrayList<>();
        for (int i = 0; i < secondsToCount; i++) {
            list.add(executorService.submit(ticker));
            list.add(executorService.submit(tacker));
        }
        list.forEach(s -> runVoid(() -> {
            watches.add(s.get());
            return null;
        }));
        return watches;
    }


}
