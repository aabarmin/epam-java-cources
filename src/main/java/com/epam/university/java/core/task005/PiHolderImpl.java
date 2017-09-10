package com.epam.university.java.core.task005;

public class PiHolderImpl implements PiHolder {
    private int numerator = 3;
    private int denomirator = 1;

    @Override
    public int getFirst() {

        return numerator;
    }

    @Override
    public int getSecond() {

        return denomirator;
    }
}
