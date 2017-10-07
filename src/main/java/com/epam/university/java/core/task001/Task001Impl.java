package com.epam.university.java.core.task001;

import com.epam.university.java.core.ChecksHelper;

/**
 * implementation class for Task001.
 *
 * @author Sergei Titov
 */
public class Task001Impl implements Task001 {

    /**
     * add two params.
     *
     * @param firstNumber string value of first number
     * @param secondNumber string value of second number
     *
     * @return the sum
     */
    @Override
    public double addition(String firstNumber, String secondNumber) {

        ChecksHelper.checkForNullAnyOfArgument(firstNumber, secondNumber);
        ChecksHelper.checkForEmptyBothArguments(firstNumber, secondNumber);
        return Double.parseDouble(firstNumber) + Double.parseDouble(secondNumber);
    }

    /**
     * subtracts two params.
     *
     * @param firstNumber string value of first number
     * @param secondNumber string value of second number
     *
     * @return the difference
     */
    @Override
    public double subtraction(String firstNumber, String secondNumber) {

        ChecksHelper.checkForNullAnyOfArgument(firstNumber, secondNumber);
        ChecksHelper.checkForEmptyBothArguments(firstNumber, secondNumber);
        return Double.parseDouble(firstNumber) - Double.parseDouble(secondNumber);
    }

    /**
     * multiplies two params.
     *
     * @param firstNumber string value of first number
     * @param secondNumber string value of second number
     *
     * @return the product
     */
    @Override
    public double multiplication(String firstNumber, String secondNumber) {

        ChecksHelper.checkForNullAnyOfArgument(firstNumber, secondNumber);
        ChecksHelper.checkForEmptyBothArguments(firstNumber, secondNumber);
        return Double.parseDouble(firstNumber) * Double.parseDouble(secondNumber);
    }

    /**
     * divides the first param by the second.
     *
     * @param firstNumber string value of first number
     * @param secondNumber string value of second number
     *
     * @return the quotient
     */
    @Override
    public double division(String firstNumber, String secondNumber) {

        ChecksHelper.checkForNullAnyOfArgument(firstNumber, secondNumber);
        ChecksHelper.checkForEmptyBothArguments(firstNumber, secondNumber);
        return Double.parseDouble(firstNumber) / Double.parseDouble(secondNumber);
    }
}
