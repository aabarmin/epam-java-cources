package com.epam.university.java.core.task005;

public class PiHolderImpl implements PiHolder {
    private double numerator;
    private double denominator;

    public PiHolderImpl(double numerator, double denominator) {
        this.numerator = numerator;
        this.denominator = denominator;
    }

    public void setPiHolder(double numerator, double denominator) {
        this.numerator = numerator;
        this.denominator = denominator;
    }

    public double getNumerator() {
        return numerator;
    }

    public double getDenominator() {
        return denominator;
    }

    @Override
    public int getFirst() {
        return (int) numerator;
    }

    @Override
    public int getSecond() {
        return (int) denominator;
    }
}