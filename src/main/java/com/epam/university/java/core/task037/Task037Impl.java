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
 * {@inheritDoc}
 */
public class Task037Impl implements Task037 {
    /**
     * {@inheritDoc}
     */
    @Override
    public Collection<String> switcher(Callable<String> ticker, Callable<String> tacker) {
        List<String> list = new ArrayList<>();
        ExecutorService tikExecutor = Executors.newFixedThreadPool(1);
        ExecutorService takExecutor = Executors.newFixedThreadPool(1);
        for (int i = 0; i < 5; i++) {
            Future<String> tikFuture = tikExecutor.submit(ticker);
            Future<String> takFuture = takExecutor.submit(tacker);
            try {
                list.add(tikFuture.get());
                list.add(takFuture.get());
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (ExecutionException e) {
                e.printStackTrace();
            }

        }
        return list;
    }
}
