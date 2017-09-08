package com.epam.university.java.core.task005;

public class PiHolderImpl implements PiHolder {
    private final int first;
    private final int second;

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
