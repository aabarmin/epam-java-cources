package com.epam.university.java.core.task005;

/**
 * Created by Doomsday Device on 20.09.2017.
 */
public class PiHolderImpl implements PiHolder {
    final int first;
    final int second;

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
