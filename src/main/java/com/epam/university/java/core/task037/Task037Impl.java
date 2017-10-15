package com.epam.university.java.core.task037;

import java.util.ArrayList;
import java.util.Collection;
import java.util.concurrent.Callable;
import java.util.concurrent.Future;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ExecutionException;
import java.util.stream.Collectors;

/**
 * Implementation class for Task037.
 *
 * @author Sergei Titov
 */
public class Task037Impl implements Task037 {

    /**
     * {@inheritDoc}
     */
    @Override
    public Collection<String> switcher(Callable<String> ticker, Callable<String> tacker) {

        final int soundCount = 10;
        Collection<Future<String>> results = new ArrayList<>(soundCount);

        // run our callable tasks
        final ExecutorService executorService = Executors.newFixedThreadPool(soundCount);
        for (int i = 0; i < soundCount / 2; i++) {
            results.add(executorService.submit(ticker));
            results.add(executorService.submit(tacker));
        }

        // tasks are submitted, service is not needed any more
        executorService.shutdown();

        // collect results
        return results.stream().map(l -> {
            try {
                return l.get();
            } catch (InterruptedException | ExecutionException ex) {
                throw new RuntimeException(ex);
            }}).collect(Collectors.toList());
    }
}
