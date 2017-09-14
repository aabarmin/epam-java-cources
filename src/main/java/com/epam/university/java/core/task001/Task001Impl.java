package com.epam.university.java.core.task001;

import com.epam.university.java.core.validation.Validator;

/**
 * Created by Александр on 06.09.2017.
 */
public class Task001Impl implements Task001 {
    private static Validator VALIDATOR = Validator.newInstance(Task001Impl.class);

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
        VALIDATOR.assertNotNull(firstNumber);
        VALIDATOR.assertNotNull(secondNumber);

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
        VALIDATOR.assertNotNull(firstNumber);
        VALIDATOR.assertNotNull(secondNumber);

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
        VALIDATOR.assertNotNull(firstNumber);
        VALIDATOR.assertNotNull(secondNumber);

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
        VALIDATOR.assertNotNull(firstNumber);
        VALIDATOR.assertNotNull(secondNumber);

        return Double.valueOf(firstNumber) / Double.valueOf(secondNumber);
    }
}
