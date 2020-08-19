package com.epam.university.java.core.task001;

/**
 * Created by A.Sluzhbin on 19.08.2020
 */

public class Task001Impl implements Task001 {

    @Override
    public double addition(String firstNumber, String secondNumber) {
        if (firstNumber == null || secondNumber == null) {
            throw new IllegalArgumentException("Arguments not found.");
        }
        double firstDouble = Double.parseDouble(firstNumber);
        double secondDouble = Double.parseDouble(secondNumber);
        return firstDouble + secondDouble;
    }

    @Override
    public double subtraction(String firstNumber, String secondNumber) {
        if (firstNumber == null || secondNumber == null) {
            throw new IllegalArgumentException("Arguments not found.");
        }
        double firstDouble = Double.parseDouble(firstNumber);
        double secondDouble = Double.parseDouble(secondNumber);
        return firstDouble - secondDouble;
    }

    @Override
    public double multiplication(String firstNumber, String secondNumber) {
        if (firstNumber == null || secondNumber == null) {
            throw new IllegalArgumentException("Arguments not found.");
        }
        double firstDouble = Double.parseDouble(firstNumber);
        double secondDouble = Double.parseDouble(secondNumber);
        return firstDouble * secondDouble;
    }

    @Override
    public double division(String firstNumber, String secondNumber) {
        if (firstNumber == null || secondNumber == null) {
            throw new IllegalArgumentException("Arguments not found.");
        }
        double firstDouble = Double.parseDouble(firstNumber);
        double secondDouble = Double.parseDouble(secondNumber);
        return firstDouble / secondDouble;
    }

}
