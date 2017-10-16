package com.epam.university.java.core.task001;

import com.epam.university.java.core.Validator;

/**
 * Realization of Task001.
 *
 * @author Александр
 */
public class Task001Impl implements Task001 {
    private Validator validator = Validator.getInstance();

    /**
     * Execute addition operation.
     *
     * @param firstNumber  string value of first number
     * @param secondNumber string value of second number
     * @return result of addition operation
     * @throws IllegalArgumentException if input parameters are not set
     * @throws NumberFormatException    if can't convert input values to numbers
     */
    @Override
    public double addition(String firstNumber, String secondNumber) {
        validator.validate(firstNumber, secondNumber);
        return Double.valueOf(firstNumber) + Double.valueOf(secondNumber);
    }

    /**
     * Execute subtraction operation.
     *
     * @param firstNumber  string value of first number
     * @param secondNumber string value of second number
     * @return result of subtraction operation
     * @throws IllegalArgumentException if input parameters are not set
     * @throws NumberFormatException    if can't convert input values to numbers
     */
    @Override
    public double subtraction(String firstNumber, String secondNumber) {
        validator.validate(firstNumber, secondNumber);
        return Double.valueOf(firstNumber) - Double.valueOf(secondNumber);
    }

    /**
     * Execute multiplication operation.
     *
     * @param firstNumber  string value of first number
     * @param secondNumber string value of second number
     * @return result of multiplication operation
     * @throws IllegalArgumentException if input parameters are not set
     * @throws NumberFormatException    if can't convert input values to numbers
     */
    @Override
    public double multiplication(String firstNumber, String secondNumber) {
        validator.validate(firstNumber, secondNumber);
        return Double.valueOf(firstNumber) * Double.valueOf(secondNumber);
    }

    /**
     * Execute division operation.
     *
     * @param firstNumber  string value of first number
     * @param secondNumber string value of second number
     * @return result of division operation
     * @throws IllegalArgumentException if input parameters are not set
     * @throws NumberFormatException    if can't convert input values to numbers
     */
    @Override
    public double division(String firstNumber, String secondNumber) {
        validator.validate(firstNumber, secondNumber);
        return Double.valueOf(firstNumber) / Double.valueOf(secondNumber);
    }
}
