package com.epam.university.java.core.task014;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class VampireNumberImpl implements VampireNumber {
    private int first;
    private int second;
    private int multiplication;

    /**
     * VampireNumber constructor.
     * @param multiplication multiplication of first and second;
     * @param first first number;
     * @param second second number;
     */
    public VampireNumberImpl(int multiplication, int first, int second) {
        this.first = first;
        this.second = second;
        this.multiplication = multiplication;
    }

    @Override
    public int getMultiplication() {
        return this.multiplication;
    }

    /**
     * Get first part of vampire number.
     * @return value of the first part
     */
    @Override
    public int getFirst() {
        return this.first;
    }

    /**
     * Get second part of vampire number.
     * @return value of the second part
     */
    @Override
    public int getSecond() {
        return this.second;
    }

    /**
     * Check if two vampire numbers are equals in spite of the order
     * of parts.
     * @param value vampire number to check
     * @return if numbers are equals
     */
    public boolean equals(Object value) {
        if (this == value) {
            return true;
        }
        if (!(value instanceof VampireNumberImpl)) {
            return false;
        }
        VampireNumberImpl that = (VampireNumberImpl) value;
        return (getFirst() == that.getFirst()
                && getSecond() == that.getSecond())
                || (getFirst() == that.getSecond()
                && getSecond() == that.getFirst());
    }

    @Override
    public int hashCode() {
        return getFirst() * getSecond();
    }
}
