package com.epam.university.java.core.task014;

/**
 * Created by Александр on 18.09.2017.
 * Some blood hungry numbers
 */
public class VampireNumberImpl implements VampireNumber {

    private final int first;
    private final int second;
    private final int multiplication;

    VampireNumberImpl(int multiplication, int fisrst, int second) {
        this.multiplication = multiplication;
        this.first = fisrst;
        this.second = second;
    }

    /**
     * Get multiplication of numbers.
     *
     * @return value of multiplication
     */
    @Override
    public int getMultiplication() {
        return first * second;
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
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        VampireNumberImpl that = (VampireNumberImpl) o;

        boolean firstAndSecond = ((first == that.first) && (second == that.second));
        boolean secondAndFirst = ((second == that.first) && (first == that.second));

        return firstAndSecond || secondAndFirst;
    }

    @Override
    public int hashCode() {
        return multiplication;
    }
}
