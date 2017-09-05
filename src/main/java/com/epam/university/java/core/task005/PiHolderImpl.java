package com.epam.university.java.core.task005;

/**
 * PiHolder implementation.
 */
public final class PiHolderImpl implements PiHolder {

    /**
     * numerator.
     */
    private int first;

    /**
     * denominator.
     */
    private int second;

    PiHolderImpl(final int first, final int second) {
        this.first = first;
        this.second = second;
    }

    @Override
    public int getFirst() {
        return first;
    }

    @Override
    public int getSecond() {
        return second;
    }

    public void setFirst(final int first) {
        this.first = first;
    }

    public void setSecond(final int second) {
        this.second = second;
    }

}
