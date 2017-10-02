package com.epam.university.java.core.task014;

import com.epam.university.java.core.utils.common.Validator;

/**
 * Implements Vampire number.
 */
public class VampireNumberImpl implements VampireNumber {

    private int multiplication;
    private int firstNumber;
    private int secondNumber;

    /**
     * Initialisation of Vampire number implementation.
     *
     * @param multiplication multiplication for the Vampire number
     * @param firstNumber    first number of Vampire number
     * @param secondNumber   second number of Vampire number
     * @throws IllegalAccessException if at least one of parameters violates
     *                                permitted range
     */
    public VampireNumberImpl(int multiplication, int firstNumber, int
            secondNumber) {
        Validator.validateValueRange(multiplication, Integer.MIN_VALUE,
                Integer.MAX_VALUE, Validator.MESSAGE_IF_VIOLATES_LOWER_BORDER,
                Validator.MESSAGE_IF_VIOLATES_UPPER_BORDER);
        Validator.validateValueRange(firstNumber, Integer.MIN_VALUE,
                Integer.MAX_VALUE, Validator.MESSAGE_IF_VIOLATES_LOWER_BORDER,
                Validator.MESSAGE_IF_VIOLATES_UPPER_BORDER);
        Validator.validateValueRange(secondNumber, Integer.MIN_VALUE,
                Integer.MAX_VALUE, Validator.MESSAGE_IF_VIOLATES_LOWER_BORDER,
                Validator.MESSAGE_IF_VIOLATES_UPPER_BORDER);
        this.multiplication = multiplication;
        this.firstNumber = firstNumber;
        this.secondNumber = secondNumber;
    }

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