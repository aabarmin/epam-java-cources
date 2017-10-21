package com.epam.university.java.core.task037;

import java.util.ArrayList;
import java.util.Collection;
import java.util.concurrent.Callable;

public class Task037Impl implements Task037 {
    @Override
    public Collection<String> switcher(Callable<String> ticker, Callable<String> tacker) {
        Collection<String> result = new ArrayList<>();
        Thread first = new Thread(() -> {
            try {
                result.add(ticker.call());
            } catch (Exception e) {
                e.printStackTrace();
            }
        });

        Thread second = new Thread(() -> {
            try {
                result.add(tacker.call());
            } catch (Exception e) {
                e.printStackTrace();
            }
        });

        for (int i = 0; i < 5; i++) {
            first.run();
            first.interrupt();
            second.run();
            second.interrupt();
        }

        return result;
    }
}
