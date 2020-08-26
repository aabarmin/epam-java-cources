package com.epam.university.java.core.task014;

public class VampireNumberImpl implements VampireNumber {
    private int multiplication;
    private int first;
    private int second;

    /**
     * Constructor, that takes 3 Integers.
     * @param multiplication of first and second
     * @param first multiplier
     * @param second multiplier
     */
    public VampireNumberImpl(int multiplication, int first, int second) {
        this.multiplication = multiplication;
        this.first = first;
        this.second = second;
    }

    @Override
    public int getMultiplication() {
        return multiplication;
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
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }

        if (obj == null || obj.getClass() != getClass()) {
            return false;
        }

        VampireNumberImpl o = (VampireNumberImpl) obj;

        return this.multiplication == o.getMultiplication()
                && this.first == o.getFirst()
                && this.second == o.getSecond();
    }
}
