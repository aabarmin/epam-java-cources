package com.epam.university.java.core.utils;

/**
 * Validation utility.
 */
public class Validator {
    public static final String MESSAGE_FOR_FIRST_PARAMETER_IF_NULL
            = "first parameter can't be null";
    public static final String MESSAGE_FOR_SECOND_PARAMETER_IF_NULL
            = "second parameter can't be null";
    public static final String MESSAGE_FOR_SOURCE_IF_NULL
            = "source can't be null";
    public static final String MESSAGE_IF_VIOLATES_LOWER_BORDER
            = "source can't violate lower border";
    public static final String MESSAGE_IF_VIOLATES_UPPER_BORDER
            = "source can't violate upper border";
    public static final String MESSAGE_FOR_FIRST_PARAMETER_IF_LENGTH_NULL
            = "first parameter's length can't be null";
    public static final String MESSAGE_FOR_SECOND_PARAMETER_IF_LENGTH_NULL
            = "second parameter's length can't be null";
    public static final String
            MESSAGE_FOR_FIRST_PARAMETER_IF_NUMBER_FORMAT_EXCEPTION
            = "can't convert first input value to number";
    public static final String
            MESSAGE_FOR_SECOND_PARAMETER_IF_NUMBER_FORMAT_EXCEPTION
            = "can't convert second input value to number";
    public static final String MESSAGE_IF_NEGATIVE = "number should be "
            + "positive";

    /**
     * Validates parameters not null.
     *
     * @param firstParameter                  first parameter to check
     * @param secondParameter                 second parameter to check
     * @param messageForFirstParameterIfNull  message if parameter is null
     * @param messageForSecondParameterIfNull message if parameter is null
     * @throws IllegalArgumentException if parameters not provided
     */
    public static void validateNotNull(Object firstParameter, Object
            secondParameter,
                                       String messageForFirstParameterIfNull,
                                       String messageForSecondParameterIfNull) {
        validateNotNull(firstParameter, messageForFirstParameterIfNull);
        validateNotNull(secondParameter, messageForSecondParameterIfNull);
    }

    /**
     * Validates parameter not null.
     *
     * @param parameter     parameter to check
     * @param messageIfNull message if parameter is null
     * @throws IllegalArgumentException if parameter not provided
     */
    public static void validateNotNull(Object parameter, String messageIfNull) {
        if (parameter == null) {
            throw new IllegalArgumentException(messageIfNull);
        }
    }

    /**
     * Validates value and length of parameters.
     *
     * @param firstParameter                        first parameter to check
     * @param secondParameter                       second parameter to check
     * @param messageForFirstParameterIfNull        message if first
     *                                              parameter is null
     * @param messageForSecondParameterIfNull       message if second parameter
     *                                              is null
     * @param messageForFirstParameterIfLengthNull  message if first parameter's
     *                                              length is null
     * @param messageForSecondParameterIfLengthNull message if first parameter's
     *                                              length is null
     * @throws IllegalArgumentException if parameters not provided or ""
     */
    public static void validateValueAndLengthNotNull(
            Object firstParameter,
            Object secondParameter,
            String messageForFirstParameterIfNull,
            String messageForSecondParameterIfNull,
            String messageForFirstParameterIfLengthNull,
            String messageForSecondParameterIfLengthNull) {
        validateValueAndLengthNotNull(firstParameter,
                messageForFirstParameterIfNull,
                messageForFirstParameterIfLengthNull);
        validateValueAndLengthNotNull(secondParameter,
                messageForSecondParameterIfNull,
                messageForSecondParameterIfLengthNull);
    }

    /**
     * Validates value and length of parameter.
     *
     * @param parameter           parameter to check
     * @param messageIfNull       message if parameter is
     *                            null
     * @param messageIfLengthNull message if parameter's
     *                            length is null
     * @throws IllegalArgumentException if parameter not provided or ""
     */
    public static void validateValueAndLengthNotNull(
            Object parameter, String messageIfNull,
            String messageIfLengthNull) {
        if (parameter == null) {
            throw new IllegalArgumentException(messageIfNull);
        }
        if (parameter == "") {
            throw new IllegalArgumentException(messageIfLengthNull);
        }
    }

    /**
     * Validates parameter not negative.
     *
     * @param parameter         parameter to check
     * @param messageIfNegative message if parameter is
     *                          negative
     * @throws IllegalArgumentException if parameter is negative
     */
    public static void validateNotNegative(long parameter, String
            messageIfNegative) {
        if (parameter < 0) {
            throw new IllegalArgumentException(messageIfNegative);
        }
    }

    /**
     * Validates number format (double).
     *
     * @param firstString                                  string to check
     * @param secondString                                 string to check
     * @param firstNumbersMessageForNumberFormatException  message if
     *                                                     format error
     * @param secondNumbersMessageForNumberFormatException message if
     *                                                     format error
     * @return double[]
     * @throws NumberFormatException if it is not possible
     *                               to parse parameter/parameters to double
     */
    public static double[] validateParseDouble(
            String firstString, String secondString,
            String firstNumbersMessageForNumberFormatException,
            String secondNumbersMessageForNumberFormatException) {
        double firstDouble;
        double secondDouble;
        try {
            firstDouble = Double.parseDouble(firstString);
        } catch (NumberFormatException ex) {
            throw new NumberFormatException(
                    firstNumbersMessageForNumberFormatException);
        }
        try {
            secondDouble = Double.parseDouble(secondString);
        } catch (NumberFormatException ex) {
            throw new NumberFormatException(
                    secondNumbersMessageForNumberFormatException);
        }
        return new double[]{firstDouble, secondDouble};
    }

    /**
     * Validates parameter is in range.
     *
     * @param value                        value to check
     * @param lowerBorder                  minimum possible value to input
     * @param upperBorder                  maximum possible value to input
     * @param messageIfViolatesLowerBorder message if value
     *                                     is violates minimum limit
     * @param messageIfViolatesUpperBorder message if value
     *                                     is violates upper limit
     * @throws IllegalArgumentException if parameter violates limits of range
     */
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