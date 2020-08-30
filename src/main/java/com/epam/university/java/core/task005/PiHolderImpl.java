package com.epam.university.java.core.task005;

/**
 * Some text.
 */
public class PiHolderImpl implements PiHolder {
    private int first;
    private int second;

    public PiHolderImpl(int first, int second) {
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
}
