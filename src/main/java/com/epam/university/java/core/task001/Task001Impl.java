package com.epam.university.java.core.task001;

/**
 * Implementation of Task001.
 */
public class Task001Impl implements Task001 {
    @Override
    public double addition(String firstNumber, String secondNumber) throws Exception {
        if (firstNumber == null || secondNumber == null) {
            throw new IllegalArgumentException();
        } else if (firstNumber.isBlank() || secondNumber.isBlank()) {
            throw new IllegalArgumentException();
        }
        return Double.parseDouble(firstNumber) + Double.parseDouble(secondNumber);
    }

    @Override
    public double subtraction(String firstNumber, String secondNumber) throws Exception {
        if (firstNumber == null || secondNumber == null) {
            throw new IllegalArgumentException();
        } else if (firstNumber.isBlank() || secondNumber.isBlank()) {
            throw new IllegalArgumentException();
        }

        return Double.parseDouble(firstNumber) - Double.parseDouble(secondNumber);
    }

    @Override
    public double multiplication(String firstNumber, String secondNumber) throws Exception {
        if (firstNumber == null || secondNumber == null) {
            throw new IllegalArgumentException();
        } else if (firstNumber.isBlank() || secondNumber.isBlank()) {
            throw new IllegalArgumentException();
        }

        return Double.parseDouble(firstNumber) * Double.parseDouble(secondNumber);
    }

    @Override
    public double division(String firstNumber, String secondNumber) throws Exception {
        if (firstNumber == null || secondNumber == null) {
            throw new IllegalArgumentException();
        } else if (firstNumber.isBlank() || secondNumber.isBlank()) {
            throw new IllegalArgumentException();
        }

        return Double.parseDouble(firstNumber) / Double.parseDouble(secondNumber);
    }
}
