package com.epam.university.java.core.task005;

import java.util.concurrent.ForkJoinTask;
import java.util.concurrent.RecursiveTask;

/**
 * Implementation of the RecursiveTask for pi computations.
 */
public class PiTask extends RecursiveTask<PiHolder> {

    private final int left;
    private final int right;
    private final int lower;
    private final int threshold = 1000; // style checker won't pass capitalized ¯\_(ツ)_/¯

    /**
     * Constructs a RecursiveTask for computing on the given interval.
     *
     * @param left lower bound of the computing interval
     * @param right higher bound of the computing interval
     * @param lower global lower interval (<= left)
     */
    public PiTask(int left, int right, int lower) {
        this.left = left;
        this.right = right;
        this.lower = lower;
    }

    /**
     * The main computation performed by this task.
     *
     * @return result of the computation
     */
    @Override
    protected PiHolder compute() {
        if (right - left <= threshold) {
            return solve(left, right, lower);
        }
        int m = (left + right) >>> 1;
        ForkJoinTask<PiHolder> t1 = new PiTask(left, m, lower);
        ForkJoinTask<PiHolder> t2 = new PiTask(m + 1, right, lower);
        t1.fork();
        t2.fork();
        PiHolder ph1 = t2.join();
        PiHolder ph2 = t1.join();
        return Math.abs(ph1.getFirst() - ph1.getSecond() * Math.PI)
            >= Math.abs(ph2.getFirst() - ph2.getSecond() * Math.PI) ? ph2 : ph1;
    }

    private static PiHolder solve(int leftBound, int rightBound, int start) {
        double minDelta = Double.MAX_VALUE;
        int minA = leftBound;
        int minB = start;
        for (int a = leftBound; a <= rightBound; ++a) {
            for (int b = start; b <= a - 1; ++b) {
                double res = Math.abs(a - b * Math.PI);
                if (res < minDelta) {
                    minDelta = res;
                    minA = a;
                    minB = b;
                }
            }
        }
        return new PiHolderImpl(minA, minB);
    }

}
