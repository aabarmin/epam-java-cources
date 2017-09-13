package com.epam.university.java.core.task001;

import com.epam.university.java.core.util.Utils;

import java.util.stream.Stream;

/**
 * Implementation of the simple calculator.
 *<p>
 *    Ordinary calculator which checks input data
 *</p>
 */
public class Task001Impl implements Task001 {

    /**
     * Execute addition operation.
     *
     * @param firstNumber string value of first number
     * @param secondNumber string value of second number
     * @return result of addition operation
     * @throws IllegalArgumentException if input parameters are not set
     * @throws NumberFormatException if can't convert input values to numbers
     */
    @Override
    public double addition(String firstNumber, String secondNumber) {
        Double[] vals = getArgs(firstNumber, secondNumber);
        return vals[0] + vals[1];
    }

    /**
     * Execute subtraction operation.
     *
     * @param firstNumber string value of first number
     * @param secondNumber string value of second number
     * @return result of subtraction operation
     * @throws IllegalArgumentException if input parameters are not set
     * @throws NumberFormatException if can't convert input values to numbers
     */
    @Override
    public double subtraction(String firstNumber, String secondNumber) {
        Double[] vals = getArgs(firstNumber, secondNumber);
        return vals[0] - vals[1];
    }

    /**
     * Execute multiplication operation.
     *
     * @param firstNumber string value of first number
     * @param secondNumber string value of second number
     * @return result of multiplication operation
     * @throws IllegalArgumentException if input parameters are not set
     * @throws NumberFormatException if can't convert input values to numbers
     */
    @Override
    public double multiplication(String firstNumber, String secondNumber) {
        Double[] vals = getArgs(firstNumber, secondNumber);
        return vals[0] * vals[1];
    }

    /**
     * Execute division operation.
     *
     * @param firstNumber string value of first number
     * @param secondNumber string value of second number
     * @return result of division operation
     * @throws IllegalArgumentException if input parameters are not set
     * @throws NumberFormatException if can't convert input values to numbers
     */
    @Override
    public double division(String firstNumber, String secondNumber) {
        Double[] vals = getArgs(firstNumber, secondNumber);
        return vals[0] / vals[1];
    }

    /**
     * Parse double arguments from given strings.
     *
     * @param args one more string values of double arguments
     * @return array of converted arguments
     * @throws IllegalArgumentException if input parameters are not set
     * @throws NumberFormatException if can't convert input values to numbers
     */
    private Double[] getArgs(String... args) {
        if (args == null) {
            throw new IllegalArgumentException();
        }
        return Stream.of(args)
            .map(arg -> {
                Utils.assertNonNull(arg);
                Utils.assertNonEmpty(arg);
                return Double.parseDouble(arg);
            })
            .toArray(Double[]::new);
    }

}
