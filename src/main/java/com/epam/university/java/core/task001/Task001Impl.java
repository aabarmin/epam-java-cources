package com.epam.university.java.core.task001;

public class Task001Impl implements Task001 {
    String firstNumberMessageForIllegalArgumentException = "first number must be the value";
    String secondNumberMessageForIllegalArgumentException = "second number must be the value";
    String firstNumberMessageForNumberFormatException = "can't convert first input value to number";
    String secondNumberMessageForNumberFormatException = "can't convert second input value to number";

    @Override
    public double addition(String firstNumber, String secondNumber) {
        if (firstNumber == "") throw new IllegalArgumentException(firstNumberMessageForIllegalArgumentException);
        if (firstNumber == null) throw new IllegalArgumentException(firstNumberMessageForIllegalArgumentException);
        if (secondNumber == "") throw new IllegalArgumentException(secondNumberMessageForIllegalArgumentException);
        if (secondNumber == null)
            throw new IllegalArgumentException(secondNumberMessageForIllegalArgumentException);
        double firstNumberConverted;
        double secondNumberConverted;
        try {
            firstNumberConverted = Double.parseDouble(firstNumber);
        } catch (NumberFormatException ex) {
            throw new NumberFormatException(firstNumberMessageForNumberFormatException);
        }
        try {
            secondNumberConverted = Double.parseDouble(secondNumber);
        } catch (NumberFormatException ex) {
            throw new NumberFormatException(secondNumberMessageForNumberFormatException);
        }
        return firstNumberConverted + secondNumberConverted;
    }

    @Override
    public double subtraction(String firstNumber, String secondNumber) {
        if (firstNumber == "") throw new IllegalArgumentException(firstNumberMessageForIllegalArgumentException);
        if (firstNumber == null) throw new IllegalArgumentException(firstNumberMessageForIllegalArgumentException);
        if (secondNumber == "") throw new IllegalArgumentException(secondNumberMessageForIllegalArgumentException);
        if (secondNumber == null)
            throw new IllegalArgumentException(secondNumberMessageForIllegalArgumentException);
        double firstNumberConverted;
        double secondNumberConverted;
        try {
            firstNumberConverted = Double.parseDouble(firstNumber);
        } catch (NumberFormatException ex) {
            throw new NumberFormatException(firstNumberMessageForNumberFormatException);
        }
        try {
            secondNumberConverted = Double.parseDouble(secondNumber);
        } catch (NumberFormatException ex) {
            throw new NumberFormatException(secondNumberMessageForNumberFormatException);
        }
        return firstNumberConverted - secondNumberConverted;
    }

    @Override
    public double multiplication(String firstNumber, String secondNumber) {
        if (firstNumber == "") throw new IllegalArgumentException(firstNumberMessageForIllegalArgumentException);
        if (firstNumber == null) throw new IllegalArgumentException(firstNumberMessageForIllegalArgumentException);
        if (secondNumber == "") throw new IllegalArgumentException(secondNumberMessageForIllegalArgumentException);
        if (secondNumber == null)
            throw new IllegalArgumentException(secondNumberMessageForIllegalArgumentException);
        double firstNumberConverted;
        double secondNumberConverted;
        try {
            firstNumberConverted = Double.parseDouble(firstNumber);
        } catch (NumberFormatException ex) {
            throw new NumberFormatException(firstNumberMessageForNumberFormatException);
        }
        try {
            secondNumberConverted = Double.parseDouble(secondNumber);
        } catch (NumberFormatException ex) {
            throw new NumberFormatException(secondNumberMessageForNumberFormatException);
        }
        return firstNumberConverted * secondNumberConverted;
    }

    @Override
    public double division(String firstNumber, String secondNumber) {
        if (firstNumber == "") throw new IllegalArgumentException(firstNumberMessageForIllegalArgumentException);
        if (firstNumber == null) throw new IllegalArgumentException(firstNumberMessageForIllegalArgumentException);
        if (secondNumber == "") throw new IllegalArgumentException(secondNumberMessageForIllegalArgumentException);
        if (secondNumber == null)
            throw new IllegalArgumentException(secondNumberMessageForIllegalArgumentException);
        double firstNumberConverted;
        double secondNumberConverted;
        try {
            firstNumberConverted = Double.parseDouble(firstNumber);
        } catch (NumberFormatException ex) {
            throw new NumberFormatException(firstNumberMessageForNumberFormatException);
        }
        try {
            secondNumberConverted = Double.parseDouble(secondNumber);
        } catch (NumberFormatException ex) {
            throw new NumberFormatException(secondNumberMessageForNumberFormatException);
        }
        if ((firstNumberConverted == 0.0) && (secondNumberConverted == 0.0)) return Double.NaN;
        if ((firstNumberConverted < 0.0) && (secondNumberConverted == 0.0)) return Double.NEGATIVE_INFINITY;
        if ((firstNumberConverted > 0.0) && (secondNumberConverted == 0.0)) return Double.POSITIVE_INFINITY;
        return firstNumberConverted / secondNumberConverted;
    }
}