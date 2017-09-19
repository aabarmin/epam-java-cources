package com.epam.university.java.core.task014;

/**
 * Created by Daniil Smirnov on 19.09.2017.
 * All copy registered MF.
 */
public class VampireNumberImpl implements VampireNumber {

    private final int multiplication;
    private final int firstPair;
    private final int secondPair;

    /**
     * Constructor for VampireFactory.
     * @param multiplication - multiplication of 2 pars.
     * @param firstPair - 1 element.
     * @param secondPair - 2 element.
     */
    public VampireNumberImpl(int multiplication, int firstPair, int secondPair) {
        this.multiplication = multiplication;
        this.firstPair = firstPair;
        this.secondPair = secondPair;
    }

    @Override
    public int getMultiplication() {
        return multiplication;
    }

    @Override
    public int getFirst() {
        return firstPair;
    }

    @Override
    public int getSecond() {
        return secondPair;
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

        if (multiplication != that.multiplication) {
            return false;
        }

        if (firstPair != that.firstPair && firstPair != that.secondPair) {
            return false;
        }

        if (secondPair != that.secondPair && secondPair != that.firstPair) {
            return false;
        }

        return true;
    }

    @Override
    public int hashCode() {
        int result = multiplication;
        result = 31 * result + firstPair;
        result = 31 * result + secondPair;
        return result;
    }

}
