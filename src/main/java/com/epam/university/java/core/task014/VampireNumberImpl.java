package com.epam.university.java.core.task014;

/**
 * Created by ilya on 16.09.17.
 */
public class VampireNumberImpl implements VampireNumber {

    private int first;
    private int second;
    private int multiplication;

    /**
     * Consturctor.
     * @param first first number
     * @param second second number
     * @param multiplication multiplication
     */
    public VampireNumberImpl(int first, int second, int multiplication) {
        this.first = first;
        this.second = second;
        this.multiplication = multiplication;
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

        if (first == that.first && second == that.second) {
            return true;
        } else if (first == that.second && second == that.first) {
            return true;
        }
        return false;
    }

    @Override
    public int hashCode() {
        int result = first;
        result = result + second;
        return result;
    }
}
