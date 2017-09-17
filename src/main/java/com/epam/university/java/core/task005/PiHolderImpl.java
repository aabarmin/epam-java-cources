package com.epam.university.java.core.task005;

/**
 * implementation class for PiHolder.
 *
 * @author Sergei Titov
 */
public class PiHolderImpl implements PiHolder {

    protected final int dividend;
    protected final int divisor;

    /**
     * constructor takes first and second (as dividend and divisor).
     */
    public PiHolderImpl(int firstParam, int secondParam) {
        dividend = firstParam;
        divisor = secondParam;
    }

    /**
     * gets dividend for Pi calculation.
     *
     * @returns first (dividend)
     */
    @Override
    public int getFirst() {
        return dividend;
    }

    /**
     * gets divisor for Pi calculation.
     *
     * @returns second (divisor)
     */
    @Override
    public int getSecond() {
        return divisor;
    }
}
