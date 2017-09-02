package com.epam.university.java.core.task001;

public class Task001Impl implements Task001 {
    @Override
    public double addition(String firstNumber, String secondNumber) {
        checkForNull(firstNumber, secondNumber);
        return Double.parseDouble(firstNumber) + Double.parseDouble(secondNumber);
    }

    @Override
    public double subtraction(String firstNumber, String secondNumber) {
        checkForNull(firstNumber, secondNumber);
        return Double.parseDouble(firstNumber) - Double.parseDouble(secondNumber);
    }

    @Override
    public double multiplication(String firstNumber, String secondNumber) {
        checkForNull(firstNumber, secondNumber);
        return Double.parseDouble(firstNumber) * Double.parseDouble(secondNumber);
    }

    @Override
    public double division(String firstNumber, String secondNumber) {
        checkForNull(firstNumber, secondNumber);
        return Double.parseDouble(firstNumber) / Double.parseDouble(secondNumber);
    }

    private void checkForNull(String firstNumber, String secondNumber) {
        if (firstNumber == null || secondNumber == null) {
            throw new IllegalArgumentException();
        }
    }
}
