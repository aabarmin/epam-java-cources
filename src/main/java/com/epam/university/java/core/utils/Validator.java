package com.epam.university.java.core.utils;

public class Validator {
    public static final String MESSAGE_FOR_FIRST_PARAMETER_IF_NULL = "first parameter can't be null";
    public static final String MESSAGE_FOR_SECOND_PARAMETER_IF_NULL = "second parameter can't be null";
    public static final String MESSAGE_FOR_SOURCE_IF_NULL = "source can't be null";
    public static final String MESSAGE_IF_VIOLATES_LOWER_BORDER = "source can't violate lower border";
    public static final String MESSAGE_IF_VIOLATES_UPPER_BORDER = "source can't violate upper border";
    public static final String MESSAGE_FOR_FIRST_PARAMETER_IF_LENGTH_NULL =
            "first parameter's length can't be null";
    public static final String MESSAGE_FOR_SECOND_PARAMETER_IF_LENGTH_NULL =
            "second parameter's length can't be null";
    public static final String MESSAGE_FOR_FIRST_PARAMETER_IF_NUMBER_FORMAT_EXCEPTION =
            "can't convert first input value to number";
    public static final String MESSAGE_FOR_SECOND_PARAMETER_IF_NUMBER_FORMAT_EXCEPTION =
            "can't convert second input value to number";
    public static final String MESSAGE_IF_NEGATIVE = "number should be positive";

    public static void validateNotNull(Object firstParameter, Object secondParameter,
                                       String messageForFirstParameterIfNull,
                                       String messageForSecondParameterIfNull) {
        validateNotNull(firstParameter, messageForFirstParameterIfNull);
        validateNotNull(secondParameter, messageForSecondParameterIfNull);
    }

    public static void validateNotNull(Object parameter, String messageIfNull) {
        if (parameter == null) {
            throw new IllegalArgumentException(messageIfNull);
        }
    }

    public static void validateValueAndLengthNotNull(Object firstParameter, Object secondParameter,
                                                     String messageForFirstParameterIfNull,
                                                     String messageForSecondParameterIfNull,
                                                     String messageForFirstParameterIfLengthNull,
                                                     String messageForSecondParameterIfLengthNull) {
        validateValueAndLengthNotNull(firstParameter, messageForFirstParameterIfNull,
                messageForFirstParameterIfLengthNull);
        validateValueAndLengthNotNull(secondParameter, messageForSecondParameterIfNull,
                messageForSecondParameterIfLengthNull);
    }

    public static void validateValueAndLengthNotNull(Object parameter, String messageIfNull,
                                                     String messageIfLengthNull) {
        if (parameter == null) {
            throw new IllegalArgumentException(messageIfNull);
        }
        if (parameter == "") {
            throw new IllegalArgumentException(messageIfLengthNull);
        }
    }

    public static void validateNotNegative(long parameter, String messageIfNegative) {
        if (parameter < 0) {
            throw new IllegalArgumentException(messageIfNegative);
        }
    }

    public static double[] validateParseDouble(String firstString, String secondString,
                                               String firstNumbersMessageForNumberFormatException,
                                               String secondNumbersMessageForNumberFormatException) {
        double firstDouble;
        double secondDouble;
        try {
            firstDouble = Double.parseDouble(firstString);
        } catch (NumberFormatException ex) {
            throw new NumberFormatException(firstNumbersMessageForNumberFormatException);
        }
        try {
            secondDouble = Double.parseDouble(secondString);
        } catch (NumberFormatException ex) {
            throw new NumberFormatException(secondNumbersMessageForNumberFormatException);
        }
        return new double[]{firstDouble, secondDouble};
    }

    public static void validateValueRange(double value, double lowerBorder,
                                          double upperBorder,
                                          String messageIfViolatesLowerBorder,
                                          String messageIfViolatesUpperBorder) {
        if (value < lowerBorder) {
            throw new IllegalArgumentException(messageIfViolatesLowerBorder);
        }
        if (value > upperBorder) {
            throw new IllegalArgumentException(messageIfViolatesUpperBorder);
        }
    }
}