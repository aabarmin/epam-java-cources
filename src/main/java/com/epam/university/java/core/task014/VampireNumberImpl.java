package com.epam.university.java.core.task014;

public class VampireNumberImpl implements VampireNumber {

    private final int first;
    private final int second;
    private final int mult;

    /**
     * Default constructor.
     * @param mult value of multiplication
     * @param first value of first number
     * @param second value of second number
     */
    public VampireNumberImpl(int mult, int first, int second) {
        this.first = first;
        this.second = second;
        this.mult = mult;
    }

    @Override
    public int getMultiplication() {
        return mult;
    }

    @Override
    public int getFirst() {
        return first;
    }

    @Override
    public int getSecond() {
        return second;
    }

    @Override
    public int hashCode() {
        return (first + second + mult);
    }

    @Override
    public boolean equals(Object obj) {
        return obj instanceof VampireNumberImpl && hashCode() == obj.hashCode();
    }

}
