package com.epam.university.java.core.task014;


public class VampireNumberImpl implements VampireNumber {

    int first;
    int second;
    int multiplication;

    /**
     * Vampire number constructor.
     * @param multiplication multiplication value
     * @param first first number
     * @param second second number
     */
    public VampireNumberImpl(int multiplication, int first, int second) {
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
        VampireNumberImpl number = (VampireNumberImpl) obj;
        return this.multiplication == number.multiplication;
    }
}
