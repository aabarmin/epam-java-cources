package com.epam.university.java.core.task001;

public class Task001Impl implements Task001 {
    @Override
    public double addition(String firstNumber, String secondNumber) {
        return doTheMath("+", firstNumber, secondNumber);
    }

    @Override
    public double subtraction(String firstNumber, String secondNumber) {
        return doTheMath("-", firstNumber, secondNumber);
    }

    @Override
    public double multiplication(String firstNumber, String secondNumber) {
        return doTheMath("*", firstNumber, secondNumber);
    }

    @Override
    public double division(String firstNumber, String secondNumber) {
        return doTheMath("/", firstNumber, secondNumber);
    }

    private double doTheMath(String operation, String firstNumber, String secondNumber) {
        if (firstNumber == null || secondNumber == null) {
            throw new NumberFormatException();
        }
        double res = 0;
        switch (operation) {
            case "+":
                res = Double.parseDouble(firstNumber) + Double.parseDouble(secondNumber);
                break;
            case "-":
                res = Double.parseDouble(firstNumber) - Double.parseDouble(secondNumber);
                break;
            case "*":
                res = Double.parseDouble(firstNumber) * Double.parseDouble(secondNumber);
                break;
            case "/":
                res = Double.parseDouble(firstNumber) / Double.parseDouble(secondNumber);
                break;
            default:
                break;
        }

        return res;
    }
}
