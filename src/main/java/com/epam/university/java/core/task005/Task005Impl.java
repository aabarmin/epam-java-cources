package com.epam.university.java.core.task005;

import java.util.concurrent.ForkJoinPool;

/**
 * Implementation of the pi computations.
 */
public class Task005Impl implements Task005 {

    /**
     * Find two numbers, quotient of which will be closest to PI number. Ex. if digit is 1,
     * holder values should be between 1 and 9, if digits is equals to 2, values should
     * be between 10 and 99 and so on.
     * <p>
     *     Tip: Math.abs((a / b) - Math.PI) -> min
     * </p>
     *
     * @param digits amount of digits in numbers.
     * @return holder which contains both numbers
     * @throws IllegalArgumentException if digits less or equals to the zero, or more than ten
     */
    @Override
    public PiHolder findPi(int digits) {
        if (digits <= 0 || digits > 10) {
            throw new IllegalArgumentException();
        }
        int lower = (int) Math.max(Math.pow(10, digits - 1), 1);
        int higher = (int) Math.pow(10, digits) - 1;
        PiTask task = new PiTask(lower, higher, lower);
        ForkJoinPool pool = new ForkJoinPool();
        return pool.invoke(task);
    }

}
