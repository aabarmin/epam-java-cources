package com.epam.university.java.core.task001;

/**
 * Simple Calculator.
 * Task001 implementation.
 */
public final class Task001Impl implements Task001 {

    /**
     * Message for empty method parameters error.
     */
    private static final String MSG_EMPTY_PARAMS = "empty method parameters";

    /**
     * Message for incorrect arguments error.
     */
    private static final String MSG_INCORRECT_ARGS = "incorrect arguments";

    @Override
    public double addition(
            final String firstNumber, final String secondNumber) {
        if (("".equals(firstNumber)) || ("".equals(secondNumber))
                || (firstNumber == null) || (secondNumber == null)) {
            throw new IllegalArgumentException(MSG_EMPTY_PARAMS);
        }
        double result;
        double op1 = 0;
        double op2 = 0;
        try {
            op1 = Double.parseDouble(firstNumber);
            op2 = Double.parseDouble(secondNumber);
        } catch (Exception e) {
            throw new NumberFormatException(MSG_INCORRECT_ARGS);
        }
        result = op1 + op2;
        return result;
    }

    @Override
    public double subtraction(
            final String firstNumber, final String secondNumber) {
        if (("".equals(firstNumber)) || ("".equals(secondNumber))
                || (firstNumber == null) || (secondNumber == null)) {
            throw new IllegalArgumentException(MSG_EMPTY_PARAMS);
        }
        double result;
        double op1 = 0;
        double op2 = 0;
        try {
            op1 = Double.parseDouble(firstNumber);
            op2 = Double.parseDouble(secondNumber);
        } catch (Exception e) {
            throw new NumberFormatException(MSG_INCORRECT_ARGS);
        }
        result = op1 - op2;
        return result;
    }

    @Override
    public double multiplication(
            final String firstNumber, final String secondNumber) {
        if (("".equals(firstNumber)) || ("".equals(secondNumber))
                || (firstNumber == null) || (secondNumber == null)) {
            throw new IllegalArgumentException(MSG_EMPTY_PARAMS);
        }
        double result;
        double op1 = 0;
        double op2 = 0;
        try {
            op1 = Double.parseDouble(firstNumber);
            op2 = Double.parseDouble(secondNumber);
        } catch (Exception e) {
            throw new NumberFormatException(MSG_INCORRECT_ARGS);
        }
        result = op1 * op2;
        return result;
    }

    @Override
    public double division(
            final String firstNumber, final String secondNumber) {
        if (("".equals(firstNumber)) || ("".equals(secondNumber))
                || (firstNumber == null) || (secondNumber == null)) {
            throw new IllegalArgumentException(MSG_EMPTY_PARAMS);
        }
        double result;
        double op1 = 0;
        double op2 = 0;
        try {
            op1 = Double.parseDouble(firstNumber);
            op2 = Double.parseDouble(secondNumber);
        } catch (Exception e) {
            throw new NumberFormatException(MSG_INCORRECT_ARGS);
        }
        result = op1 / op2;
        return result;
    }
}
