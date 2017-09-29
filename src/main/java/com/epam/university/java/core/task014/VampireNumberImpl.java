package com.epam.university.java.core.task014;

public class VampireNumberImpl implements VampireNumber {
    int multiplication;
    int first;
    int second;

    /**
     * Constructor for vampire number instance.
     * @param multiplication multiplication value
     * @param first first part value
     * @param second second part value
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
    public boolean equals(Object obj) {
        return obj instanceof VampireNumber
            && (
                ((VampireNumber) obj).getFirst() == first
                || ((VampireNumber) obj).getSecond() == first
            )
            && ((VampireNumber) obj).getMultiplication() == multiplication;
    }
}
