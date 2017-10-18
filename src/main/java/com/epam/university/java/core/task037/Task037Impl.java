package com.epam.university.java.core.task037;

import java.util.ArrayList;
import java.util.Collection;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.stream.Collectors;

public class Task037Impl implements Task037 {

    @Override
    public Collection<String> switcher(Callable<String> ticker, Callable<String> tacker)
        throws ExecutionException, InterruptedException {

        Collection<Future<String>> result = new ArrayList<>();

        ExecutorService service = Executors.newCachedThreadPool();

        for (int i = 0; i < 5; i++) {
            result.add(service.submit(ticker));
            result.add(service.submit(tacker));
        }

        return result.parallelStream().map(f -> {
            try {
                return f.get();
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (ExecutionException e) {
                e.printStackTrace();
            }
            return "";
        }).collect(Collectors.toList());
    }


}
