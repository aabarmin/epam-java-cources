package com.epam.university.java.core.task014;

public class VampireNumberImpl implements VampireNumber {
    private int firstNumber;
    private int secondNumber;
    private int multiplication;

    VampireNumberImpl(int multiplication, int firstNumber, int secondNumber) {
        this.multiplication = multiplication;
        this.firstNumber = firstNumber;
        this.secondNumber = secondNumber;
    }

    @Override
    public int getMultiplication() {
        return multiplication;
    }

    @Override
    public int getFirst() {
        return firstNumber;
    }

    @Override
    public int getSecond() {
        return secondNumber;
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
        return firstNumber == that.firstNumber || firstNumber == that.secondNumber
                && (secondNumber == that.secondNumber || secondNumber == that.firstNumber
                && multiplication == that.multiplication);
    }
}