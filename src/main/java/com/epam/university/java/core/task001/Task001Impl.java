package com.epam.university.java.core.task001;

public class Task001Impl implements Task001 {
    @Override
    public double addition(String firstNumber, String secondNumber) {
        isNullBothArguments(firstNumber, secondNumber);

        double firstArg = Double.parseDouble(firstNumber);
        double secondArg = Double.parseDouble(secondNumber);

        return firstArg + secondArg;
    }

    @Override
    public double subtraction(String firstNumber, String secondNumber) {
        isNullBothArguments(firstNumber, secondNumber);

        double firstArg = Double.parseDouble(firstNumber);
        double secondArg = Double.parseDouble(secondNumber);

        return firstArg - secondArg;
    }

    @Override
    public double multiplication(String firstNumber, String secondNumber) {
        isNullBothArguments(firstNumber, secondNumber);

        double firstArg = Double.parseDouble(firstNumber);
        double secondArg = Double.parseDouble(secondNumber);

        return firstArg * secondArg;
    }

    @Override
    public double division(String firstNumber, String secondNumber) {
        isNullBothArguments(firstNumber, secondNumber);

        double firstArg = Double.parseDouble(firstNumber);
        double secondArg = Double.parseDouble(secondNumber);

        return firstArg / secondArg;
    }

    private void isNullBothArguments(String firstNumber, String secondNumber) {
        if (firstNumber == null || secondNumber == null) {
            throw new IllegalArgumentException();
        }
    }
}
