package com.epam.university.java.core.task001;

/**
 * Created by Mirabilis on 03.09.2017.
 */
public class Task001Impl implements Task001 {
    @Override
    public double addition(String firstNumber, String secondNumber) {
        if(firstNumber==null||secondNumber==null) throw new IllegalArgumentException();
        double a = Double.parseDouble(firstNumber);
        double b = Double.parseDouble(secondNumber);
        return a+b;
    }

    @Override
    public double subtraction(String firstNumber, String secondNumber) {
        if(firstNumber==null||secondNumber==null) throw new IllegalArgumentException();
        return Double.parseDouble(firstNumber) - Double.parseDouble(secondNumber);
    }

    @Override
    public double multiplication(String firstNumber, String secondNumber) {
        if(firstNumber==null||secondNumber==null) throw new IllegalArgumentException();
        double a = Double.parseDouble(firstNumber);
        double b = Double.parseDouble(secondNumber);
        return a*b;
    }

    @Override
    public double division(String firstNumber, String secondNumber) {
        if(firstNumber==null||secondNumber==null) throw new IllegalArgumentException();
        double a = Double.parseDouble(firstNumber);
        double b = Double.parseDouble(secondNumber);
        return a/b;
    }
}
