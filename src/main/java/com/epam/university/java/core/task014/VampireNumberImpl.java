package com.epam.university.java.core.task014;

import java.util.HashMap;

public class VampireNumberImpl implements VampireNumber {
    private int multiplication;
    private int first;
    private int second;

    /**
     * Just a minimalistic constructor.
     * @param multiplication first * second
     * @param first first 2-digit number
     * @param second second
     */
    public VampireNumberImpl(int multiplication, int first, int second) {
        this.multiplication = multiplication;
        this.first = first;
        this.second = second;
    }

    /**
     * Get multiplication of numbers.
     *
     * @return value of multiplication
     */
    @Override
    public int getMultiplication() {
        return first * second;
    }

    /**
     * Get first part of vampire number.
     *
     * @return value of the first part
     */
    @Override
    public int getFirst() {
        return first;
    }

    /**
     * Get second part of vampire number.
     *
     * @return value of the second part
     */
    @Override
    public int getSecond() {
        return second;
    }

    /**
     * Method to compare vampireNumbers.
     *
     * @param vampireNumber vampire number.
     * @return true if they are the same.
     */
    @Override
    public boolean equals(Object vampireNumber) {
        if (this.multiplication == ((VampireNumberImpl) vampireNumber).multiplication) {
            return true;
        }
        return false;
    }
}
