package com.epam.university.java.core.task001;

import com.epam.university.java.core.utils.common.Validator;

public class Task001Impl implements Task001 {

    @Override
    public double addition(String firstNumber, String secondNumber) {
        Validator.validateValueAndLengthNotNull(firstNumber, secondNumber,
                Validator.MESSAGE_FOR_FIRST_PARAMETER_IF_NULL,
                Validator.MESSAGE_FOR_SECOND_PARAMETER_IF_NULL,
                Validator.MESSAGE_FOR_FIRST_PARAMETER_IF_LENGTH_NULL,
                Validator.MESSAGE_FOR_SECOND_PARAMETER_IF_LENGTH_NULL);
        double[] doubles = Validator.validateParseDouble(
                firstNumber, secondNumber,
                Validator
                        .MESSAGE_FOR_FIRST_PARAMETER_IF_NUMBER_FORMAT_EXCEPTION,
                Validator
                        .MESSAGE_FOR_SECOND_PARAMETER_IF_NUMBER_FORMAT_EXCEPTION);
        return doubles[0] + doubles[1];
    }

    @Override
    public double subtraction(String firstNumber, String secondNumber) {
        Validator.validateValueAndLengthNotNull(firstNumber, secondNumber,
                Validator.MESSAGE_FOR_FIRST_PARAMETER_IF_NULL,
                Validator.MESSAGE_FOR_SECOND_PARAMETER_IF_NULL,
                Validator.MESSAGE_FOR_FIRST_PARAMETER_IF_LENGTH_NULL,
                Validator.MESSAGE_FOR_SECOND_PARAMETER_IF_LENGTH_NULL);
        double[] doubles = Validator.validateParseDouble(firstNumber,
                secondNumber,
                Validator
                        .MESSAGE_FOR_FIRST_PARAMETER_IF_NUMBER_FORMAT_EXCEPTION,
                Validator
                        .MESSAGE_FOR_SECOND_PARAMETER_IF_NUMBER_FORMAT_EXCEPTION);
        return doubles[0] - doubles[1];
    }

    @Override
    public double multiplication(String firstNumber, String secondNumber) {
        Validator.validateValueAndLengthNotNull(firstNumber, secondNumber,
                Validator.MESSAGE_FOR_FIRST_PARAMETER_IF_NULL,
                Validator.MESSAGE_FOR_SECOND_PARAMETER_IF_NULL,
                Validator.MESSAGE_FOR_FIRST_PARAMETER_IF_LENGTH_NULL,
                Validator.MESSAGE_FOR_SECOND_PARAMETER_IF_LENGTH_NULL);
        double[] doubles = Validator.validateParseDouble(firstNumber,
                secondNumber,
                Validator
                        .MESSAGE_FOR_FIRST_PARAMETER_IF_NUMBER_FORMAT_EXCEPTION,
                Validator
                        .MESSAGE_FOR_SECOND_PARAMETER_IF_NUMBER_FORMAT_EXCEPTION);
        return doubles[0] * doubles[1];
    }

    @Override
    public double division(String firstNumber, String secondNumber) {
        Validator.validateValueAndLengthNotNull(firstNumber, secondNumber,
                Validator.MESSAGE_FOR_FIRST_PARAMETER_IF_NULL,
                Validator.MESSAGE_FOR_SECOND_PARAMETER_IF_NULL,
                Validator.MESSAGE_FOR_FIRST_PARAMETER_IF_LENGTH_NULL,
                Validator.MESSAGE_FOR_SECOND_PARAMETER_IF_LENGTH_NULL);
        double[] doubles = Validator.validateParseDouble(firstNumber,
                secondNumber,
                Validator
                        .MESSAGE_FOR_FIRST_PARAMETER_IF_NUMBER_FORMAT_EXCEPTION,
                Validator
                        .MESSAGE_FOR_SECOND_PARAMETER_IF_NUMBER_FORMAT_EXCEPTION);
        if ((doubles[0] == 0.0) && (doubles[1] == 0.0)) {
            return Double.NaN;
        }
        if ((doubles[0] < 0.0) && (doubles[1] == 0.0)) {
            return Double.NEGATIVE_INFINITY;
        }
        if ((doubles[0] > 0.0) && (doubles[1] == 0.0)) {
            return Double.POSITIVE_INFINITY;
        }
        return doubles[0] / doubles[1];
    }
}