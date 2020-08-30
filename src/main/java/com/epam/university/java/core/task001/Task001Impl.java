package com.epam.university.java.core.task001;

public class Task001Impl implements Task001 {

    @Override
    public double addition(String firstNumber, String secondNumber)
            throws IllegalArgumentException {
        if (firstNumber == null || secondNumber == null) {
            throw new IllegalArgumentException();
        }
        double firstNumberParsed = Double.parseDouble(firstNumber);
        double secondNumberParsed = Double.parseDouble(secondNumber);
        return firstNumberParsed + secondNumberParsed;
    }

    @Override
    public double subtraction(String firstNumber, String secondNumber)
            throws IllegalArgumentException {
        if (firstNumber == null || secondNumber == null) {
            throw new IllegalArgumentException();
        }
        double firstNumberParsed = Double.parseDouble(firstNumber);
        double secondNumberParsed = Double.parseDouble(secondNumber);
        return firstNumberParsed - secondNumberParsed;
    }

    @Override
    public double multiplication(String firstNumber, String secondNumber)
            throws IllegalArgumentException {
        if (firstNumber == null || secondNumber == null) {
            throw new IllegalArgumentException();
        }
        double firstNumberParsed = Double.parseDouble(firstNumber);
        double secondNumberParsed = Double.parseDouble(secondNumber);
        return firstNumberParsed * secondNumberParsed;
    }

    @Override
    public double division(String firstNumber, String secondNumber)
            throws IllegalArgumentException {
        if (firstNumber == null || secondNumber == null) {
            throw new IllegalArgumentException();
        }
        double firstNumberParsed = Double.parseDouble(firstNumber);
        double secondNumberParsed = Double.parseDouble(secondNumber);
        return firstNumberParsed / secondNumberParsed;
    }
}
