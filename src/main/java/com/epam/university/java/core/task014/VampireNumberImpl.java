package com.epam.university.java.core.task014;

import java.util.Objects;

/**
 * Created by Romin Nuro on 26.08.2020 15:21.
 */

public class VampireNumberImpl implements VampireNumber {
    private final int first;
    private final int second;
    private final int multiplication;


    /**
     * Constructor.
     *
     * @param first first number
     * @param second second number
     */
    public VampireNumberImpl(int first, int second) {
        this.first = first;
        this.second = second;
        this.multiplication = first * second;
    }
    /**
     * Get multiplication of numbers.
     * @return value of multiplication
     */

    @Override
    public int getMultiplication() {
        return this.multiplication;
    }

    /**
     * Get first part of vampire number.
     * @return value if first part
     */
    @Override
    public int getFirst() {
        return this.first;
    }
    /**
     * Get second part of vampire number.
     * @return value of second part
     */

    @Override
    public int getSecond() {
        return this.second;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof VampireNumberImpl)) {
            return false;
        }
        VampireNumberImpl that = (VampireNumberImpl) o;
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
