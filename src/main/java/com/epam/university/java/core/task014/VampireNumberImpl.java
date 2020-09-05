package com.epam.university.java.core.task014;

import java.util.Objects;

/**
 * Author Dmitry Novikov 05-Sep-20.
 */
public class VampireNumberImpl implements VampireNumber {

    private int multiplication;
    private int first;
    private int second;

    /**
     * SomeText.
     */
    public VampireNumberImpl(int multiplication, int first, int second) {
        this.multiplication = multiplication;
        this.first = first;
        this.second = second;
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
        return multiplication == that.multiplication;
    }

    @Override
    public int hashCode() {
        return Objects.hash(multiplication);
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


}
