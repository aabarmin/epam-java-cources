package com.epam.university.java.core.task001;

import com.epam.university.java.core.utils.Validator;

public class Task001Impl implements Task001 {
    public static final String errorMessageForFirstParameterIfNull = "first number can't be null";
    public static final String errorMessageForSecondParameterIfNull = "second number can't be null";
    public static final String errorMessageForFirstParameterIfLengthNull =
            "first number's length can't be null";
    public static final String errorMessageForSecondParameterIfLengthNull =
            "first number's length can't be null";
    public static final String firstNumberMessageForNumberFormatException =
            "can't convert first input value to number";
    public static final String secondNumberMessageForNumberFormatException =
            "can't convert second input value to number";

    @Override
    public double addition(String firstNumber, String secondNumber) {
        Validator.validateValueAndLengthNotNull(firstNumber, secondNumber,
                errorMessageForFirstParameterIfNull, errorMessageForSecondParameterIfNull,
                errorMessageForFirstParameterIfLengthNull, errorMessageForSecondParameterIfLengthNull);
        double[] doubles = Validator.validateParseDouble(firstNumber, secondNumber,
                firstNumberMessageForNumberFormatException, secondNumberMessageForNumberFormatException);
        return doubles[0] + doubles[1];
    }

    @Override
    public double subtraction(String firstNumber, String secondNumber) {
        Validator.validateValueAndLengthNotNull(firstNumber, secondNumber,
                errorMessageForFirstParameterIfNull, errorMessageForSecondParameterIfNull,
                errorMessageForFirstParameterIfLengthNull, errorMessageForSecondParameterIfLengthNull);
        double[] doubles = Validator.validateParseDouble(firstNumber, secondNumber,
                firstNumberMessageForNumberFormatException, secondNumberMessageForNumberFormatException);
        return doubles[0] - doubles[1];
    }

    @Override
    public double multiplication(String firstNumber, String secondNumber) {
        Validator.validateValueAndLengthNotNull(firstNumber, secondNumber,
                errorMessageForFirstParameterIfNull, errorMessageForSecondParameterIfNull,
                errorMessageForFirstParameterIfLengthNull, errorMessageForSecondParameterIfLengthNull);
        double[] doubles = Validator.validateParseDouble(firstNumber, secondNumber,
                firstNumberMessageForNumberFormatException, secondNumberMessageForNumberFormatException);
        return doubles[0] * doubles[1];
    }

    @Override
    public double division(String firstNumber, String secondNumber) {
        Validator.validateValueAndLengthNotNull(firstNumber, secondNumber,
                errorMessageForFirstParameterIfNull, errorMessageForSecondParameterIfNull,
                errorMessageForFirstParameterIfLengthNull, errorMessageForSecondParameterIfLengthNull);
        double[] doubles = Validator.validateParseDouble(firstNumber, secondNumber,
                firstNumberMessageForNumberFormatException, secondNumberMessageForNumberFormatException);
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