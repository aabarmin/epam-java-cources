package com.epam.university.java.core.task005;

public class PiHolderImpl implements PiHolder {
    private int first;
    private int second;

    double valueOfEps() {
        return Math.abs((double) first / (double) second - Math.PI);
    }

    PiHolderImpl(int numerator, int denominator) {
        this.first = numerator;
        this.second = denominator;
    }

    public void setFirst(int numerator) {
        this.first = numerator;
    }

    public void setSecond(int denumerator) {
        this.second = denumerator;
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
