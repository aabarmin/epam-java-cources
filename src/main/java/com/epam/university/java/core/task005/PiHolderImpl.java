package com.epam.university.java.core.task005;

public class PiHolderImpl implements PiHolder {
    private int numerator;
    private int denominator;

    PiHolderImpl(int numerator, int denominator) {
        this.numerator = numerator;
        this.denominator = denominator;
    }

    @Override
    public int getFirst() {
        return numerator;
    }

    @Override
    public int getSecond() {
        return denominator;
    }
}
