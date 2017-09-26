package com.epam.university.java.core.task014;

public class VampireNumberImpl implements VampireNumber {
    private int multiplication;
    private int first;
    private int second;

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
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        VampireNumberImpl that = (VampireNumberImpl) o;

        return multiplication == that.multiplication
                && (first == that.first && second == that.second
                || second == that.first && first == that.second);

    }

    @Override
    public int hashCode() {
        int result = multiplication;
        result = 31 * result + first + second;
        return result;
    }
}
