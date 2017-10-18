package com.epam.university.java.core.task037;

import java.util.Collection;
import java.util.LinkedList;
import java.util.concurrent.Callable;

import java.util.concurrent.Semaphore;

public class Task037Impl implements Task037 {
    private static final int TICKS_COUNT = 5;
    final Semaphore semaphore1 = new Semaphore(1, true);
    final Semaphore semaphore2 = new Semaphore(0, true);

    @Override
    public Collection<String> switcher(Callable<String> ticker, Callable<String> tacker) {
        final Collection<String> list = new LinkedList<>();
        Thread tickThread = new Thread(() -> {
            for (int i = 0; i < TICKS_COUNT; i++) {
                try {
                    semaphore1.acquire();
                    list.add(ticker.call());
                    semaphore2.release();

                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
        Thread tackThread = new Thread(() -> {

            for (int i = 0; i < TICKS_COUNT; i++) {
                try {
                    semaphore2.acquire();
                    list.add(tacker.call());
                    semaphore1.release();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
        tickThread.start();
        tackThread.start();
        try {
            tickThread.join();
            tackThread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return list;
    }
}
