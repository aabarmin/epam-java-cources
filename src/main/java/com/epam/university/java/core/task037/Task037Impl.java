package com.epam.university.java.core.task037;

import java.util.Collection;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by Вера on 16.10.2017.
 */
public class Task037Impl implements Task037 {
    @Override
    public Collection<String> switcher(Callable<String> ticker, Callable<String> tacker) {

        ExecutorService service = Executors.newFixedThreadPool(2);
        return null;
    }
}
