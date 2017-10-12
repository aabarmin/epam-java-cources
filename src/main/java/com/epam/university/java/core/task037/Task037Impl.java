package com.epam.university.java.core.task037;

import java.util.Collection;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.Semaphore;

public class Task037Impl implements Task037 {

    private static final int count = 5;

    /**
     * Implement wall watches using concurrency.
     * @param ticker produces "tick" string
     * @param tacker produces "tack" string
     * @return collection of tick-tack's
     */
    @Override
    public Collection<String> switcher(Callable<String> ticker, Callable<String> tacker) {

        final Semaphore tickSemaphore = new Semaphore(1, true);
        final Semaphore tackSemaphore = new Semaphore(0, true);

        final Deque<String> tickTacks = new LinkedBlockingDeque<>();
        final List<Thread> threads = new LinkedList<>();

        for (int i = 0; i < count; i++) {
            final Thread tickThread = new Thread(() -> {
                System.out.println("tick start");
                try {
                    tickSemaphore.acquire();
                    tickTacks.add(ticker.call());
                    tackSemaphore.release();
                } catch (Exception e) {
                    e.printStackTrace();
                }
                System.out.println("tick end");
            });
            tickThread.start();
            threads.add(tickThread);
            final Thread tackThread = new Thread(() -> {
                System.out.println("tack start");
                try {
                    tackSemaphore.acquire();
                    tickTacks.add(tacker.call());
                    tickSemaphore.release();
                } catch (Exception e) {
                    e.printStackTrace();
                }
                System.out.println("tack end");
            });
            tackThread.start();
            threads.add(tackThread);
        }

        threads.forEach(t -> {
            try {
                t.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        return tickTacks;
    }

}
