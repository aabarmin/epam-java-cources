package com.epam.university.java.core.task001;

public class Task001Impl implements Task001 {
    @Override
    public double addition(String firstNumber, String secondNumber) {
        double resForAddition;
        if (firstNumber == null || secondNumber == null) {
            throw new IllegalArgumentException();
        } else {
            try {
                resForAddition = Double.parseDouble(firstNumber) + Double.parseDouble(secondNumber);
            } catch (NumberFormatException e) {
                throw new NumberFormatException();
            }
        }
        return resForAddition;
    }

    @Override
    public double subtraction(String firstNumber, String secondNumber) {
        double resForSub;
        if (firstNumber == null || secondNumber == null) {
            throw new IllegalArgumentException();
        } else {
            try {
                resForSub = Double.parseDouble(firstNumber) - Double.parseDouble(secondNumber);
            } catch (NumberFormatException e) {
                throw new NumberFormatException();
            }
        }
        return resForSub;
    }

    @Override
    public double multiplication(String firstNumber, String secondNumber) {
        double resForMult;
        if (firstNumber == null || secondNumber == null) {
            throw new IllegalArgumentException();
        } else {
            try {
                resForMult = Double.parseDouble(firstNumber) * Double.parseDouble(secondNumber);
            } catch (NumberFormatException e) {
                throw new NumberFormatException();
            }
        }
        return resForMult;
    }

    @Override
    public double division(String firstNumber, String secondNumber) {
        double resForDiv;
        if (firstNumber == null || secondNumber == null) {
            throw new IllegalArgumentException();
        } else {
            try {
                resForDiv = Double.parseDouble(firstNumber) / Double.parseDouble(secondNumber);
            } catch (NumberFormatException e) {
                throw new NumberFormatException();
            }
        }
        return resForDiv;
    }
}
