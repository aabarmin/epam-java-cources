package com.epam.university.java.core.task005;

/**
 * Created by Romin Nuro on 25.08.2020 15:28.
 */
public class PiHolderImpl implements PiHolder {
    private int first;
    private int second;

    public PiHolderImpl(int first, int second) {
        this.first = first;
        this.second = second;
    }

    /**
     * Numerator value.
     *
     * @return value of numerator
     */
    @Override
    public int getFirst() {
        return first;
    }

    /**
     * Denominator value.
     *
     * @return value of denominator
     */
    @Override
    public int getSecond() {
        return second;
    }
}
