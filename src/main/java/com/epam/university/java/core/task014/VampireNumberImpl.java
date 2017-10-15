package com.epam.university.java.core.task014;


/**
 * {@inheritDoc}
 */
public class VampireNumberImpl implements VampireNumber {
    private int multiplication;
    private int first;
    private int second;


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

    /**
     * {@inheritDoc}
     */
    @Override
    public int hashCode() {
        return multiplication;
    }

    /**
     * Create new instance of Vampire Number with designed figures.
     *
     * @param multiplication Vampire number
     * @param first          first multiplier
     * @param second         second multiplier
     */
    protected VampireNumberImpl(int multiplication, int first, int second) {
        this.multiplication = multiplication;
        this.first = first;
        this.second = second;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public int getMultiplication() {
        return multiplication;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public int getFirst() {
        return first;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public int getSecond() {
        return second;
    }
}
