package com.epam.university.java.core.task014;

/**
 * Vampire number holder implementation.
 */
public class VampireNumberImpl implements VampireNumber {

    private final int multiplication;
    private final int first;
    private final int second;

    /**
     * Constructs a new instance of vampire number holder.
     * @param multiplication vampire value
     * @param first first fang value
     * @param second second fang value
     */
    public VampireNumberImpl(int multiplication, int first, int second) {
        this.multiplication = multiplication;
        this.first = first;
        this.second = second;
    }

    /**
     * Get multiplication of numbers.
     *
     * @return value of multiplication
     */
    @Override
    public int getMultiplication() {
        return multiplication;
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

    /**
     * Checks if two vampire numbers are equal in spite of the order
     * of parts.
     *
     * @param value vampire number to check
     * @return if numbers are equal
     */
    @Override
    public boolean equals(Object value) {
        if (this == value) {
            return true;
        }
        if (value == null || getClass() != value.getClass()) {
            return false;
        }
        VampireNumberImpl that = (VampireNumberImpl) value;
        return multiplication == that.multiplication
            && first == that.first && second == that.second;
    }

    /**
     * Returns a hash code value for the object.
     *
     * @return a hash code value for this object
     */
    @Override
    public int hashCode() {
        int result = multiplication;
        result = 31 * result + first;
        result = 31 * result + second;
        return result;
    }
}
