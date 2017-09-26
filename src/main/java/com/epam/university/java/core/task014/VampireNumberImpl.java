package com.epam.university.java.core.task014;

import java.util.Objects;

/**
 * Vampire number holder interface.
 */
public class VampireNumberImpl implements VampireNumber {

    private final int multiplication;
    private final int first;
    private final int second;

    /**
     * GraphImpl constructor.
     *
     * @param multiplication multiplication of first and second
     * @param first first vampire number
     * @param second second vampire number
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
        return multiplication;
    }

    /**
     * Get first part of vampire number.
     *
     * @return value if first part
     */
    @Override
    public int getFirst() {
        return first;
    }

    /**
     * Get second part of vampire number.
     *
     * @return value of second part
     */
    @Override
    public int getSecond() {
        return second;
    }

    @Override
    public String toString() {
        return "VampireNumberImpl{"
                + "multiplication=" + multiplication
                + ", first=" + first
                + ", second=" + second
                + '}';
    }

    @Override
    public boolean equals(Object o) {

        if (this == o) {
            return true;
        }

        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        VampireNumberImpl that = (VampireNumberImpl) o;

        return multiplication == that.multiplication
                && ((first == that.first && second == that.second)
                        || (first == that.second && second == that.first));

    }

    @Override
    public int hashCode() {
        return Objects.hash(multiplication, first, second);
    }
}
