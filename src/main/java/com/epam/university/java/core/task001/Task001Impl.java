package com.epam.university.java.core.task001;

public class Task001Impl implements Task001 {
    @Override
    public double addition(String firstNumber, String secondNumber) {
        validateInput(firstNumber, secondNumber);

        Double first = Double.parseDouble(firstNumber.trim());
        Double second = Double.parseDouble(secondNumber.trim());

        return first + second;
    }

    @Override
    public double subtraction(String firstNumber, String secondNumber) {
        validateInput(firstNumber, secondNumber);


        Double first = Double.parseDouble(firstNumber.trim());
        Double second = Double.parseDouble(secondNumber.trim());

        return first - second;
    }

    @Override
    public double multiplication(String firstNumber, String secondNumber) {
        validateInput(firstNumber, secondNumber);

        Double first = Double.parseDouble(firstNumber);
        Double second = Double.parseDouble(secondNumber);

        return first * second;
    }

    @Override
    public double division(String firstNumber, String secondNumber) {
        validateInput(firstNumber, secondNumber);


        Double first = Double.parseDouble(firstNumber);
        Double second = Double.parseDouble(secondNumber);

        return first / second;
    }

    private void validateInput(String firstNumber, String secondNumber) {
        if (firstNumber == null || secondNumber == null) {
            throw new IllegalArgumentException();
        }
    }
}
