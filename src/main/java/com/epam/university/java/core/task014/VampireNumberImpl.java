package com.epam.university.java.core.task014;

public class VampireNumberImpl implements VampireNumber {

    private int multiplication;
    private int first;
    private int second;

    /**
     * Constructor.
     * @param multiplication first * second
     * @param first first number
     * @param second second number
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
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        VampireNumberImpl obj = (VampireNumberImpl) o;

        boolean thisAndObj = ((first == obj.first) && (second == obj.second));
        boolean objAndThis = ((second == obj.first) && (first == obj.second));

        return thisAndObj || objAndThis;
    }

    @Override
    public int hashCode() {
        return 39 * multiplication;
    }

}
