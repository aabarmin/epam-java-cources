package com.epam.university.java.core.task014;

public class VampireNumberImpl implements VampireNumber {
    private int first;
    private int second;
    private int multiplication;

    /**
     * allargs constructor.
     * @param first first part of vampire number
     * @param second second part of vampire number
     * @param multiplication vampire number
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
    public boolean equals(Object obj) {
        if (obj instanceof VampireNumber) {
            VampireNumber number = (VampireNumber) obj;
            if ((this.first == number.getFirst() && this.second == number.getSecond())
                    || (this.second == number.getFirst() && this.first == number.getSecond())) {
                return true;
            }
        }
        return false;
    }
}
