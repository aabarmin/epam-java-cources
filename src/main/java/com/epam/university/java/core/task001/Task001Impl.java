package com.epam.university.java.core.task001;

public class Task001Impl implements Task001 {

    @java.lang.Override
    public double addition(String firstNumber, String secondNumber)
            throws IllegalArgumentException, NumberFormatException {
        if (firstNumber == null || secondNumber == null) {
            throw new IllegalArgumentException();
        }

        return (Double.parseDouble(firstNumber) + Double.parseDouble(secondNumber));
    }

    @java.lang.Override
    public double subtraction(String firstNumber, String secondNumber)
            throws IllegalArgumentException, NumberFormatException {
        if (firstNumber == null || secondNumber == null) {
            throw new IllegalArgumentException();
        }

        return (Double.parseDouble(firstNumber) - Double.parseDouble(secondNumber));
    }

    @java.lang.Override
    public double multiplication(String firstNumber, String secondNumber)
            throws IllegalArgumentException, NumberFormatException {

        if (firstNumber == null || secondNumber == null) {
            throw new IllegalArgumentException();
        }

        return (Double.parseDouble(firstNumber) * Double.parseDouble(secondNumber));
    }

    @java.lang.Override
    public double division(String firstNumber, String secondNumber)
            throws IllegalArgumentException, NumberFormatException {

        if (firstNumber == null || secondNumber == null) {
            throw new IllegalArgumentException();
        }

        return (Double.parseDouble(firstNumber) / Double.parseDouble(secondNumber));
    }
}
