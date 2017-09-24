package com.epam.university.java.core.task014;

/**
 * Implementation class for VampireNumber.
 *
 * @author Sergei Titov
 */
public class VampireNumberImpl implements VampireNumber, Comparable<VampireNumberImpl> {

    private final int multiplication;
    private final int first;
    private final int second;

    public VampireNumberImpl(int multiplication, int first, int second) {
        this.multiplication = multiplication;
        this.first  = (first < second) ? first : second;
        this.second = (first > second) ? first : second;
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

    /**
     * Compares internals of VampireNumberImpl class
     *
     * @param obj is an object to compare with.
     *
     * @returns 0 if both pairs (first, second) are equal (order insensitive),
     * otherwise compares multiplication fields
     */
    @Override
    public int compareTo(VampireNumberImpl obj) {

        int objFirst  = (obj.getFirst() < obj.getSecond()) ? obj.getFirst() : obj.getSecond();
        int objSecond = (obj.getFirst() > obj.getSecond()) ? obj.getFirst() : obj.getSecond();

        return (objFirst == first && objSecond == second) ? 0 :
                (multiplication > obj.getMultiplication() ? 1 : -1);
    }

    @Override
    /**
     * Compares internals of VampireNumberImpl class
     *
     * @param obj is an object to compare with.
     *
     * @returns true if (0 == this.compareTo(obj))
     */
    public boolean equals(Object obj) {
        if (!(obj instanceof VampireNumberImpl)) {
            return false;
        }
        return (0 == compareTo((VampireNumberImpl)obj));
    }
}
