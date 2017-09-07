package com.epam.university.java.core.task001;

/**
 * Created by Вера on 06.09.2017.
 */
public class Task001Impl implements Task001 {
    public double firstDouble;
    public double secondDouble;

    @Override
    public double addition(String firstNumber, String secondNumber) {
        if (firstNumber == null || secondNumber == null)
            throw new IllegalArgumentException();
        try {
            firstDouble = Double.parseDouble(firstNumber);
            secondDouble = Double.parseDouble(secondNumber);
        }
        catch (Exception e) {
            throw new NumberFormatException();
        }

        return firstDouble+secondDouble;
    }

    @Override
    public double subtraction(String firstNumber, String secondNumber) {
        if (firstNumber == null || secondNumber == null)
            throw new IllegalArgumentException();
        try {
            firstDouble = Double.parseDouble(firstNumber);
            secondDouble = Double.parseDouble(secondNumber);
        }
        catch (Exception e) {
            throw new NumberFormatException();
        }
        return firstDouble-secondDouble;
    }

    @Override
    public double multiplication(String firstNumber, String secondNumber) {
        if (firstNumber == null || secondNumber == null)
            throw new IllegalArgumentException();
        try {
            firstDouble = Double.parseDouble(firstNumber);
            secondDouble = Double.parseDouble(secondNumber);
        }
        catch (Exception e) {
            throw new NumberFormatException();
        }
        return firstDouble*secondDouble;
    }

    @Override
    public double division(String firstNumber, String secondNumber) {
        if (firstNumber == null || secondNumber == null)
            throw new IllegalArgumentException();
        try {
            firstDouble = Double.parseDouble(firstNumber);
            secondDouble = Double.parseDouble(secondNumber);
        }
        catch (Exception e) {
            throw new NumberFormatException();
        }
        return firstDouble/secondDouble;
    }
}
