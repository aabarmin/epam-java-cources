package com.epam.university.java.core.task005;


import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;


public class Task005Impl implements Task005 {

    @Override
    public PiHolder findPi(int digits) {
        if (digits <= 0 || digits > 10) {
            throw new IllegalArgumentException();
        }

        int high = (int) Math.pow(10, digits) - 1;
        int low = (int) Math.pow(10, digits - 1);

        double min = Double.MAX_VALUE;
        PiHolder piHolder = null;
        for (int i = low + 1; i <= high; i++) {
            for (int j = low; j < i; j++) {
                double abs = Math.abs(i - j * Math.PI);
                if (abs < min) {
                    min = abs;
                    piHolder = new PiHolderImpl(i, j);
                }
            }
        }
        return piHolder;
    }

}


