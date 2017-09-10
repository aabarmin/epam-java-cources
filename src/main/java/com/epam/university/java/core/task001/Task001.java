package com.epam.university.java.core.task001;

/**
 * Calculator.
 * <p>
 *     Implementing ordinary calculator which checks input data.
 * </p>
 */
public interface Task001 {
    /**
     * Execute addition operation.
     *
     * @param firstNumber string value of first number
     * @param secondNumber string value of second number
     * @return result of addition operation
     * @throws IllegalArgumentException if input parameters are not set
     * @throws NumberFormatException if can't convert input values to numbers
     */
    double addition(String firstNumber, String secondNumber);

    /**
     * Execute subtraction operation.
     *
     * @param firstNumber string value of first number
     * @param secondNumber string value of second number
     * @return result of subtraction operation
     * @throws IllegalArgumentException if input parameters are not set
     * @throws NumberFormatException if can't convert input values to numbers
     */
    double subtraction(String firstNumber, String secondNumber);

    /**
     * Execute multiplication operation.
     *
     * @param firstNumber string value of first number
     * @param secondNumber string value of second number
     * @return result of multiplication operation
     * @throws IllegalArgumentException if input parameters are not set
     * @throws NumberFormatException if can't convert input values to numbers
     */
    double multiplication(String firstNumber, String secondNumber);

    /**
     * Execute division operation.
     *
     * @param firstNumber string value of first number
     * @param secondNumber string value of second number
     * @return result of division operation
     * @throws IllegalArgumentException if input parameters are not set
     * @throws NumberFormatException if can't convert input values to numbers
     */
    double division(String firstNumber, String secondNumber);
}
