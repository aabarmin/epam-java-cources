package com.epam.university.java.core.task001;

public class Task001Impl implements Task001 {
    @Override
    public double addition(String firstNumber, String secondNumber) {
        nullChecker(firstNumber, secondNumber);
        double firstDouble = Double.parseDouble(firstNumber);
        double secondDouble = Double.parseDouble(secondNumber);

        return firstDouble + secondDouble;
    }

    @Override
    public double subtraction(String firstNumber, String secondNumber) {
        nullChecker(firstNumber, secondNumber);
        double firstDouble = Double.parseDouble(firstNumber);
        double secondDouble = Double.parseDouble(secondNumber);

        return firstDouble - secondDouble;
    }

    @Override
    public double multiplication(String firstNumber, String secondNumber) {
        nullChecker(firstNumber, secondNumber);
        double firstDouble = Double.parseDouble(firstNumber);
        double secondDouble = Double.parseDouble(secondNumber);

        return firstDouble * secondDouble;
    }

    @Override
    public double division(String firstNumber, String secondNumber) {
        nullChecker(firstNumber, secondNumber);
        double firstDouble = Double.parseDouble(firstNumber);
        double secondDouble = Double.parseDouble(secondNumber);

        return firstDouble / secondDouble;
    }

    public static void nullChecker(Object first, Object second){
        if(first == null || second == null){
            throw new IllegalArgumentException();
        }
    }
}
