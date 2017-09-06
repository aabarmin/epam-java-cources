package com.epam.university.java.core.task005;

/**
 * Created by Александр on 07.09.2017.
 */
public class PiHolderImpl implements PiHolder {
    private final int numerator;
    private final int denominator;

    public PiHolderImpl(int numerator, int denominator){
        this.numerator = numerator;
        this.denominator = denominator;
    }

    /**
     * Numerator value.
     *
     * @return value of numerator
     */
    @Override
    public int getFirst() {
        return numerator;
    }

    /**
     * Denominator value.
     *
     * @return value of denominator
     */
    @Override
    public int getSecond() {
        return denominator;
    }
}
