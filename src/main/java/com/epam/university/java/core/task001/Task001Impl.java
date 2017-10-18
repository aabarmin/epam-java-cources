package com.epam.university.java.core.task001;



/**
 * Created by Vadim on 09.09.2017.
 */
public class Task001Impl implements Task001 {
    @Override
    public double addition(String firstNumber, String secondNumber) {
        if (firstNumber == null || secondNumber == null) {
            throw new IllegalArgumentException();
        }
        if (!isNumber(firstNumber) || !isNumber(secondNumber)) {
            throw new NumberFormatException();
        }
        double numberOne = Double.parseDouble(firstNumber);
        double numberTwo = Double.parseDouble(secondNumber);
        return numberOne + numberTwo;
    }

    @Override
    public double subtraction(String firstNumber, String secondNumber) {
        if (firstNumber == null || secondNumber == null) {
            throw new IllegalArgumentException();
        }
        if (!isNumber(firstNumber) || !isNumber(secondNumber)) {
            throw new NumberFormatException();
        }
        double numberOne = Double.parseDouble(firstNumber);
        double numberTwo = Double.parseDouble(secondNumber);
        return numberOne - numberTwo;
    }

    @Override
    public double multiplication(String firstNumber, String secondNumber) {
        if (firstNumber == null || secondNumber == null) {
            throw new IllegalArgumentException();
        }
        if (!isNumber(firstNumber) || !isNumber(secondNumber)) {
            throw new NumberFormatException();
        }
        double numberOne = Double.parseDouble(firstNumber);
        double numberTwo = Double.parseDouble(secondNumber);
        return numberOne * numberTwo;
    }

    @Override
    public double division(String firstNumber, String secondNumber) {
        if (firstNumber == null || secondNumber == null) {
            throw new IllegalArgumentException();
        }
        if (!isNumber(firstNumber) || !isNumber(secondNumber)) {
            throw new NumberFormatException();
        }
        double numberOne = Double.parseDouble(firstNumber);
        double numberTwo = Double.parseDouble(secondNumber);
        return numberOne / numberTwo;
    }

    static boolean isNumber(String s) throws NumberFormatException {
        try {
            Double.parseDouble(s);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }
}
