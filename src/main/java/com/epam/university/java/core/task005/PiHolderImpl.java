package com.epam.university.java.core.task005;

public class PiHolderImpl implements PiHolder {

    private int numerator;
    private int denomimator;

    public PiHolderImpl(int numerator, int denomimator) {
        this.numerator = numerator;
        this.denomimator = denomimator;
    }

    @Override
    public int getFirst() {
        return numerator;
    }

    @Override
    public int getSecond() {
        return denomimator;
    }
}
