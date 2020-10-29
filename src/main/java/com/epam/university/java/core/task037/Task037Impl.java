package com.epam.university.java.core.task037;

import java.util.ArrayList;
import java.util.Collection;
import java.util.concurrent.Callable;

public class Task037Impl implements Task037 {
    @Override
    public Collection<String> switcher(Callable<String> ticker, Callable<String> tacker) {

        if (ticker == null || tacker == null) {
            throw new IllegalArgumentException();
        }

        Collection<String> list = new ArrayList<>();
        try {
            for (int i = 0; i < 5; i++) {
                list.add(ticker.call());
                list.add(tacker.call());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return list;
    }
}
