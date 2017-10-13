package com.epam.university.java.core.task014;

public class VampireNumberImpl implements VampireNumber {
    private final int multiplication;
    private final int first;
    private final int second;

    /**
     * Constructor - create new object of GraphImpl.
     *
     * @param multiplication multiplication of first and second numbers
     * @param first          first number
     * @param second         second number
     */
    VampireNumberImpl(int multiplication, int first, int second) {
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
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof VampireNumberImpl)) {
            return false;
        }

        VampireNumberImpl that = (VampireNumberImpl) o;

        return (multiplication == that.multiplication)
                && (first == that.first || first == that.second)
                && (second == that.first || second == that.second);
    }

    @Override
    public int hashCode() {
        int result = multiplication;
        result = 31 * result + first;
        result = 31 * result + second;
        return result;
    }
}
