package com.epam.university.java.core.task014;

public class VampireNumberImpl implements VampireNumber {
    public VampireNumberImpl(int multiplication, int firstNumber, int
            secondNumber) {
        this.multiplication = multiplication;
        this.firstNumber = firstNumber;
        this.secondNumber = secondNumber;
    }

    private int multiplication;
    private int firstNumber;
    private int secondNumber;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof VampireNumberImpl)) return false;

        VampireNumberImpl that = (VampireNumberImpl) o;

        return multiplication == that.multiplication;
    }

    @Override
    public int hashCode() {
        return multiplication;
    }

    @Override
    public String toString() {
        return "VampireNumberImpl{" +
                "multiplication=" + multiplication +
                ", firstNumber=" + firstNumber +
                ", secondNumber=" + secondNumber +
                '}'
                + System.lineSeparator();
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
}