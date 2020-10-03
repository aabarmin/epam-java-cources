package com.epam.university.java.core.task005;

/**
 * Implementation of data holder.
 *
 */
public class PiHolderImpl implements PiHolder {
    int first;
    int second;

    /**
     * Constructor for PiHolder.
     * @param first  value of numerator
     * @param second value of denominator
     */
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
        return this.first;
    }

    /**
     * Denominator value.
     *
     * @return value of denominator
     */
    @Override
    public int getSecond() {
        return this.second;
    }
}
